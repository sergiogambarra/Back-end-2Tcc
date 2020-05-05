package br.edu.ifrs.restinga.requisicoes.modelo.servico;

import br.edu.ifrs.restinga.requisicoes.modelo.dao.PaginacaoRepository;
import br.edu.ifrs.restinga.requisicoes.modelo.dao.UsuarioDao;
import br.edu.ifrs.restinga.requisicoes.modelo.dto.UsuarioDto;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.PerfilAluno;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.PerfilProfessor;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.PerfilServidor;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
import br.edu.ifrs.restinga.requisicoes.modelo.rn.RegraNenocio;
import br.edu.ifrs.restinga.requisicoes.modelo.rn.UsuarioRN;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.OrderBy;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
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
    private PerfilServico servicoPerfilServico;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PerfilServico perfilServico;

    @Autowired
    private UsuarioRN rn;

    @Override
    public PaginacaoRepository<Usuario, Long> getDAO() {
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
    public Usuario cadastrar(Usuario u) {
        rn.validar(u);
        String NomeCase = u.getPerfil().getNome().toUpperCase();
        u.getPerfil().setNome(NomeCase);
        u.setEmail(u.getEmail());
        u.setUserName(u.getUsername());
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        perfilServico.salvarPerfil(u);
        return dao.save(u);
    }

    @Transactional
    public Usuario pesquisaLogin(String nome) {
        return dao.findByUserName(nome);
    }

    public List<Usuario> listarAluno() {
        Iterable<Usuario> usuarios = dao.findAll();
        ArrayList<Usuario> alunos = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario.getPerfil().getTipo().equals("ALUNO")) {
                alunos.add(usuario);
            }
        }
        System.out.println(alunos);
        return alunos;
    }

    public List<Usuario> listarProfessor() {
        Iterable<Usuario> usuarios = dao.findAll();
        ArrayList<Usuario> professores = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario.getPerfil().getTipo().equals("PROFESSOR")) {
                professores.add(usuario);
            }
        }
        return professores;
    }

//    @OrderBy(value ="ser")
    public List<Usuario> listarServidor() {
        Iterable<Usuario> usuarios = dao.findAll();
        ArrayList<Usuario> servidores = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario.getPerfil().getTipo().equals("SERVIDOR")) {
                servidores.add(usuario);
            }
        }
        return servidores;
    }

    @Override
    public Usuario atualizar(Usuario entidade) {
        Usuario usuarioAntigo = recuperar(entidade.getId());
        usuarioAntigo.setEmail(entidade.getEmail());

        if (entidade.getPerfil() instanceof PerfilAluno) {
            PerfilAluno aluno = (PerfilAluno) entidade.getPerfil();
            PerfilAluno perfilAlunoAntigo = (PerfilAluno) usuarioAntigo.getPerfil();
            perfilAlunoAntigo.setNome(aluno.getNome());
            perfilAlunoAntigo.setMatricula(aluno.getMatricula());
            perfilAlunoAntigo.setDataIngresso(aluno.getDataIngresso());
        } else if (entidade.getPerfil() instanceof PerfilProfessor) {
            PerfilProfessor professor = (PerfilProfessor) entidade.getPerfil();
            PerfilProfessor perfilProfessor = (PerfilProfessor) usuarioAntigo.getPerfil();
            perfilProfessor.setNome(professor.getNome());
            perfilProfessor.setCoordenador(professor.isCoordenador());
            perfilProfessor.setSiape(professor.getSiape());
        } else if (entidade.getPerfil() instanceof PerfilServidor) {
            PerfilServidor servidor = (PerfilServidor) entidade.getPerfil();
            PerfilServidor perfilServidor = (PerfilServidor) usuarioAntigo.getPerfil();
            perfilServidor.setNome(servidor.getNome());
            perfilServidor.setSiape(servidor.getSiape());
        }
        perfilServico.salvarPerfil(usuarioAntigo);
        return usuarioAntigo;
    }

    public Usuario atualizarSenha(Usuario u) {
        Usuario usuarioAntigo = recuperar(u.getId());
        usuarioAntigo.setPassword(passwordEncoder.encode(u.getPassword()));
        return dao.save(usuarioAntigo);
    }
    

}
