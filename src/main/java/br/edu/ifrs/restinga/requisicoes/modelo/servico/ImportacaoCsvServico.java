/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.requisicoes.modelo.servico;

import br.edu.ifrs.restinga.requisicoes.modelo.dao.CursoDao;
import br.edu.ifrs.restinga.requisicoes.modelo.dao.DisciplinaDao;
import br.edu.ifrs.restinga.requisicoes.modelo.dao.PerfilDao;
import br.edu.ifrs.restinga.requisicoes.modelo.dao.UsuarioDao;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Curso;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Disciplina;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.PerfilProfessor;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
import br.edu.ifrs.restinga.requisicoes.modelo.exception.MensagemErroGenericaException;
import br.edu.ifrs.restinga.requisicoes.modelo.rn.DisciplinaRN;
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

    @Autowired
    DisciplinaDao disciplinaDao;

    @Autowired
    private DisciplinaRN rn;

    int contLinhaErro = 0;

    public void importacaoCsvCurso(MultipartFile arquivo) throws IOException {
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

    public void ImportarDisciplinas(MultipartFile arquivo) throws IOException {
        contLinhaErro = 0;
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(arquivo.getInputStream(), "UTF-8"))) {
            fileReader.lines().forEach((t)
                    -> {
                String[] csv = t.split(";");
                contLinhaErro++;
                if (contLinhaErro == 1) {

                } else {
                    Disciplina disciplina = new Disciplina(csv[0], Integer.parseInt(csv[1]));
                    if (disciplina.getCargaHoraria() < 15 || disciplina.getCargaHoraria() > 300 || disciplina.getNome().length() > 45 || "".equals(disciplina.getNome().trim())) {
                        System.out.println("Não foi possível cadastrar linha " + contLinhaErro + " campo vazio ou carga horária não está correta. ");
                    } else {
                        disciplinaDao.save(disciplina);
                    }
                }

            });

        }
    }
}
