package br.edu.ifrs.restinga.requisicoes.config;

import br.edu.ifrs.restinga.requisicoes.modelo.dao.CursoDao;
import br.edu.ifrs.restinga.requisicoes.modelo.dao.PerfilDao;
import br.edu.ifrs.restinga.requisicoes.modelo.dao.UsuarioDao;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Curso;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Perfil;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.PerfilServidor;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.CursoServico;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.ServicoCRUD;
import java.io.File;
import java.util.Scanner;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Xinicializador {

    @Autowired
    UsuarioDao usuarioDAO;

    @Value("${admin.nome}")
    private String admin;
    @Value("${admin.senha}")
    private String senha;
    @Value("${admin.email}")
    private String emailContato;

    @Autowired
    PerfilDao perfilDao;

    @Autowired
    PasswordEncoder encode;

    @Autowired
    CursoServico servico;

    public ServicoCRUD<Curso> getService() {
        return servico;
    }
    @Autowired
    CursoDao dao;

    @PostConstruct
    public void init() {

//        File arquivoCsv = new File("C:\\Users\\jader\\Área de Trabalho\\TCC\\cursos.csv");
//
//        try {
//            String linhasArquivo = new String();
//            Scanner leitor = new Scanner(arquivoCsv);
//            leitor.nextLine();
//            while (leitor.hasNext()) {
//                linhasArquivo = leitor.nextLine();
//                String[] valoresEntreVirgulas = linhasArquivo.split(";");
//                Curso curso = new Curso();
//                curso.setNome(valoresEntreVirgulas[0]);
//                servico.cadastrar(curso);
//                
//            }
//
//        } catch (Exception e) {
//        };

        if (!usuarioDAO.findById(1L).isPresent()) {
            Usuario usuario = new Usuario();
            usuario.setUserName(this.admin);
            usuario.setPassword(encode.encode(this.senha));
            usuario.setPermissao("SERVIDOR");
            usuario.setEmail(this.emailContato);
            PerfilServidor perfilServidor = new PerfilServidor(1, "Administrador", "ADMIN");
            perfilDao.save(perfilServidor);
            usuario.setPerfil(perfilServidor);
            usuarioDAO.save(usuario);
        }
    }
}
