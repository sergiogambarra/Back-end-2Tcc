package br.edu.ifrs.restinga.requisicoes.config;

import br.edu.ifrs.restinga.requisicoes.modelo.dao.PerfilDao;
import br.edu.ifrs.restinga.requisicoes.modelo.dao.UsuarioDao;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.PerfilServidor;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Xinicializador {
   
    @Autowired
    UsuarioDao usuarioDAO;
    
    @Autowired
    PerfilDao perfilDao;
    
    @Autowired
    PasswordEncoder encode;
    
    @PostConstruct
    public void init() {
        Usuario user = usuarioDAO.findByUserName("root");
        if (user == null) {
            Usuario usuario = new Usuario();
            usuario.setUserName("root");
            usuario.setPassword(encode.encode("123"));
            usuario.setPermissao("ADMIN");
            PerfilServidor perfilServidor = new PerfilServidor(1, "Administrador","ADMIN");
            perfilDao.save(perfilServidor);
            usuario.setPerfil(perfilServidor);
            usuarioDAO.save(usuario);
        }
    }
}