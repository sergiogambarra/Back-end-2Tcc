/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.requisicoes.modelo.servico;

import br.edu.ifrs.restinga.requisicoes.modelo.dao.CursoDao;
import br.edu.ifrs.restinga.requisicoes.modelo.dao.PerfilDao;
import br.edu.ifrs.restinga.requisicoes.modelo.dao.UsuarioDao;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Curso;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Perfil;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.PerfilProfessor;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImportacaoCsvServico {

    @Autowired
    CursoDao cursoDao;

    @Autowired
    UsuarioDao usuarioDao;

    @Autowired
    PerfilDao perfilDao;

    public void importacaoCsv(MultipartFile arquivo) throws IOException {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(arquivo.getInputStream(), "UTF-8"))) {
            fileReader.lines().forEach((t)
                    -> {
                String[] csv = t.split(";");
                Curso curso = new Curso(csv[0]);

                List<Usuario> usuarios = usuarioDao.findByNome(csv[1]);
                if (!usuarios.isEmpty()) {
                    Usuario usuario = usuarios.get(0);
                    PerfilProfessor perfil = (PerfilProfessor) usuario.getPerfil();
                    perfil.setCoordenador(true);
                    curso.setUsuario(usuario);
                    cursoDao.save(curso);
                }
            });

        }
    }
}
