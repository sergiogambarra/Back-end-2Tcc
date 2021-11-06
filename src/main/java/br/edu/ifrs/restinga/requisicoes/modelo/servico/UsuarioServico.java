package br.edu.ifrs.restinga.requisicoes.modelo.servico;

import br.edu.ifrs.restinga.requisicoes.modelo.dao.PaginacaoRepository;
import br.edu.ifrs.restinga.requisicoes.modelo.dao.PerfilAlunoDao;
import br.edu.ifrs.restinga.requisicoes.modelo.dao.UsuarioDao;
import br.edu.ifrs.restinga.requisicoes.modelo.dto.UsuarioDto;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.PerfilAluno;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.PerfilProfessor;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.PerfilServidor;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
import br.edu.ifrs.restinga.requisicoes.modelo.rn.RegraNenocio;
import br.edu.ifrs.restinga.requisicoes.modelo.rn.UsuarioRN;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.directory.Attributes;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ldap.NamingException;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

@Service
public class UsuarioServico extends ServicoCRUD<Usuario> implements UserDetailsService {

    @Autowired
    private UsuarioDao dao;

    @Autowired
	private LdapTemplate ldapTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PerfilServico perfilServico;
    
    @Autowired
    private PerfilAlunoDao perfilAlunoDao;

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
        if (usuario == null){
			usuario = (Usuario) ldapTemplate.search(query().where("uid").is(username), new PersonAttributesMapper()).get(0);
            perfilServico.salvarPerfil(usuario);
            this.cadastrar(usuario);
            return User.builder().username(usuario.getUsername()).password(usuario.getPassword()).roles(usuario.getPermissao()).build();
        }
        rn.validaUsuarioNaoEncontrado(usuario);
        return User.builder().username(usuario.getUsername()).password(usuario.getPassword()).roles(usuario.getPermissao()).build();
    }

    public Usuario autenticar(UsuarioDto user) {
        rn.validaLogin(user.getUserName(), user.getPassword());
        UserDetails details = loadUserByUsername(user.getUserName());
        if (!this.autenticarLdap(user.getUserName(), user.getPassword()))
            rn.validaSenhaBanco(user.getPassword(), details);
        Usuario usuario = dao.findByUserName(details.getUsername());
        return usuario;
    }

    public Boolean autenticarLdap(String user, String Pass) {
        try {
			ldapTemplate.authenticate(query().where("uid").is(user),Pass);
			return true;
		} catch (Throwable e){
			e.getMessage();
			return false;
		}
    }

    public Boolean pesquisarLdap(String user) {
        try {
            ldapTemplate.findOne(query().where("uid").is(user), Usuario.class);
			return true;
		} catch (Throwable e){
			e.getMessage();
			return false;
		}
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
        if (entidade.getEmail() != null) {
            rn.validaEmail(entidade.getEmail());
            usuarioAntigo.setEmail(entidade.getEmail());
        }
        //        usuarioAntigo.setAlterouSenha(false);

        if (entidade.getPerfil() instanceof PerfilAluno) {
            PerfilAluno aluno = (PerfilAluno) entidade.getPerfil();
            PerfilAluno perfilAlunoAntigo = (PerfilAluno) usuarioAntigo.getPerfil();
            perfilAlunoAntigo.setNome(aluno.getNome().toUpperCase());
            perfilAlunoAntigo.setMatricula(aluno.getMatricula());
            perfilAlunoAntigo.setDataIngresso(aluno.getDataIngresso());
        } else if (entidade.getPerfil() instanceof PerfilProfessor) {
            PerfilProfessor professor = (PerfilProfessor) entidade.getPerfil();
            PerfilProfessor perfilProfessor = (PerfilProfessor) usuarioAntigo.getPerfil();
            if (professor.getNome() != null)
                perfilProfessor.setNome(professor.getNome().toUpperCase());
            if (professor.isCoordenador() != perfilProfessor.isCoordenador())
                perfilProfessor.setCoordenador(professor.isCoordenador());
//            perfilProfessor.setSiape(professor.getSiape());
        } else if (entidade.getPerfil() instanceof PerfilServidor) {
            PerfilServidor servidor = (PerfilServidor) entidade.getPerfil();
            PerfilServidor perfilServidor = (PerfilServidor) usuarioAntigo.getPerfil();
            perfilServidor.setNome(servidor.getNome().toUpperCase());
            perfilServidor.setSiape(servidor.getSiape());
        }
        perfilServico.salvarPerfil(usuarioAntigo);
        return usuarioAntigo;
    }

    public Usuario atualizarSenha(Usuario u) {
        Usuario usuarioAntigo = recuperar(u.getId());
        usuarioAntigo.setPassword(passwordEncoder.encode(u.getPassword()));
        usuarioAntigo.setAlterouSenha(false);
        return dao.save(usuarioAntigo);
    }

    public Usuario listaUsuarioMatricula(String matricula){
        return dao.findByPerfilMatricula(matricula);
    }

    public Usuario listaProfessorSiape(String siape){
        return dao.findByPerfilSiape(siape);
    }

    public Usuario listaProfessorSiapeLdap(String siape){
        Usuario user = (Usuario) ldapTemplate.search(query().where("uid").is(siape), new PersonAttributesMapper()).get(0);
        if (user.getPermissao().equals("PROFESSOR")){
            return user;
        } else {
            return null;
        }
    }
    
    public Page<Usuario> listarPaginacao(Pageable p, String tipo) {
        return dao.listarUsuarios(tipo,p);
    }
    
    public List<Usuario> listarPesquisaNome(String nome){
        return dao.findByNome(nome);
    }

    public class PersonAttributesMapper implements AttributesMapper<Usuario> {
		public Usuario mapFromAttributes(Attributes attrs) throws NamingException {

			Usuario person = new Usuario();

			person.setUserName(null != attrs.get("uid") ? attrs.get("uid").toString().substring(5) : null);
			person.setEmail(null != attrs.get("mail") ? attrs.get("mail").toString().substring(6) : null);
			person.setPermissao(null != attrs.get("eduPersonPrimaryAffiliation") ? attrs.get("eduPersonPrimaryAffiliation").toString() : null);
			person.setPassword("senhadoldap");

			if (person.getPermissao().equals("eduPersonPrimaryAffiliation: faculty")) {
                person.setPerfil(new PerfilProfessor(attrs.get("uid").toString().substring(5),
                        attrs.get("displayName").toString().substring(13)));
                person.setPermissao("PROFESSOR");

            } else if (person.getPermissao().equals("eduPersonPrimaryAffiliation: employee") &&
                    (person.getUsername().equals("01810561") || person.getUsername().equals("02347797")) || person.getUsername().equals("02009506")) {
                person.setPermissao("SERVIDOR");
                person.setPerfil(new PerfilServidor(
                        attrs.get("uid").toString().substring(5), "Registros Escolares",
                        attrs.get("displayName").toString().substring(13)
                ));
            } else if (person.getPermissao().equals("eduPersonPrimaryAffiliation: student")) {
                person.setPerfil(new PerfilAluno(
                        attrs.get("uid").toString().substring(5),
                        attrs.get("displayName").toString().substring(13)
                        ));
                person.setPermissao("ALUNO");

            }
			return person;
		}

        private class PersonNameAttributesMapper implements AttributesMapper<String> {
		    public String mapFromAttributes(Attributes attrs) throws NamingException, javax.naming.NamingException {
			    return attrs.get("cn").get().toString();
		    }
	    }
    }

 }
