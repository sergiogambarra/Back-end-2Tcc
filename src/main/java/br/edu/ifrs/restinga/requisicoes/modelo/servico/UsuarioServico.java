package br.edu.ifrs.restinga.requisicoes.modelo.servico;

import br.edu.ifrs.restinga.requisicoes.modelo.dao.UsuarioDao;
import br.edu.ifrs.restinga.requisicoes.modelo.dto.UsuarioDto;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
import br.edu.ifrs.restinga.requisicoes.modelo.rn.RegraNenocio;
import br.edu.ifrs.restinga.requisicoes.modelo.rn.UsuarioRN;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServico extends ServicoCRUD<Usuario> implements UserDetailsService {

    @Autowired
    private UsuarioDao dao;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PerfilServico perfilServico;

    @Autowired
    private UsuarioRN rn;

    @Override
    public CrudRepository<Usuario, Long> getDAO() {
        return dao;
    }

    @Override
    public RegraNenocio<Usuario> rn() {
        return rn;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = dao.findByUserName(username);
        rn.validaUsuarioNaoEncontrado(usuario);
        return User.builder().username(usuario.getUsername()).password(usuario.getPassword()).roles(usuario.getPermissao()).build();
    }

    public Usuario autenticar(UsuarioDto user) {
        rn.validaLogin(user.getUserName(), user.getPassword());
        UserDetails details = loadUserByUsername(user.getUserName());
        rn.validaSenhaBanco(user.getPassword(), details);
        Usuario usuario = dao.findByUserName(details.getUsername());
        return usuario;
    }

    @Transactional
    @Override
    public ResponseEntity<Usuario> cadastrar(Usuario u) {
        rn.validar(u);
        String NomeCase = u.getPerfil().getNome().toUpperCase();
        u.getPerfil().setNome(NomeCase);
        String toUpperCase = u.getUsername().toUpperCase();
        u.setUserName(toUpperCase);
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        perfilServico.salvarPerfil(u);
        return new ResponseEntity(dao.save(u), HttpStatus.CREATED);
    }

    @Transactional
    public ResponseEntity<Usuario>pesquisaLogin(String nome){
        return new ResponseEntity(dao.findByUserName(nome.toUpperCase()).getUsername(), HttpStatus.CREATED);
   }

    public ResponseEntity<Usuario> listarUsuarios() {
        Iterable<Usuario> usuarios = dao.findAll();
        ArrayList<Usuario> alunos = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if(usuario.getPerfil().getTipo().equals("ALUNO")){
                alunos.add(usuario);
            }
        }
                return new ResponseEntity(alunos,HttpStatus.OK); 
    }
}
