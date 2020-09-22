/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.requisicoes.modelo.servico;

import br.edu.ifrs.restinga.requisicoes.modelo.dao.CursoDao;
import br.edu.ifrs.restinga.requisicoes.modelo.dao.DisciplinaDao;
import br.edu.ifrs.restinga.requisicoes.modelo.dao.PerfilDao;
import br.edu.ifrs.restinga.requisicoes.modelo.dao.PerfilProfessorDao;
import br.edu.ifrs.restinga.requisicoes.modelo.dao.UsuarioDao;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Curso;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Disciplina;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.PerfilProfessor;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
import br.edu.ifrs.restinga.requisicoes.modelo.rn.DisciplinaRN;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PerfilProfessorDao perfilProfessorDao;

    @Autowired
    PasswordEncoder encode;

    @Autowired
    PerfilServico perfilServico;

    int contLinhaErro = 0;

    public void importacaoCsvCurso(MultipartFile arquivo) throws IOException {
        contLinhaErro = 0;
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(arquivo.getInputStream(), "UTF-8"))) {
            fileReader.lines().forEach((t)
                    -> {
                String[] csv = t.split(";");
                contLinhaErro++;
                if (contLinhaErro == 1) {

                } else {
                    Curso curso = new Curso(csv[0]);

                    List<Usuario> usuarios = usuarioDao.findByNome(csv[1]);
                    if (!usuarios.isEmpty() && !"".equals(curso.getNome())) {
                        Usuario usuario = usuarios.get(0);
                        PerfilProfessor perfil = (PerfilProfessor) usuario.getPerfil();
                        perfil.setCoordenador(true);
                        curso.setUsuario(usuario);
                        cursoDao.save(curso);
                    } else {
                        System.out.println("Não foi possível cadastrar linha " + contLinhaErro + " campo está vazio ou coordenador não está cadastrado.");
                    }
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

    public void ImportarProfessor(MultipartFile arquivo) throws IOException {
        contLinhaErro = 0;
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(arquivo.getInputStream(), "UTF-8"))) {
            fileReader.lines().forEach((String t)
                    -> {
                String[] csv = t.split(";");
                contLinhaErro++;
                if (contLinhaErro == 1) {

                } else {

                    PerfilProfessor perfilProfessor = new PerfilProfessor();
                    Usuario usuario = new Usuario();
//                    usuario.setPerfil(perfilProfessor);
                    usuario.setEmail(csv[2]);
                    usuario.setPermissao("PROFESSOR");
                    usuario.setUserName(csv[1]);
                    usuario.setPassword(encode.encode("123456"));

                    perfilProfessor.setNome(csv[0]);
                    perfilProfessor.setSiape(Integer.parseInt(csv[1]));
                    
                    usuarioDao.save(usuario);

                    if (csv[3].equalsIgnoreCase("sim")) {
                        perfilProfessor.setCoordenador(true);
                        String tipo = perfilProfessor.getTipo();
                        tipo = "professor";
                        perfilDao.save(perfilProfessor);
                    } else {
                        perfilProfessor.setCoordenador(false);
                        String tipo = perfilProfessor.getTipo();
                        tipo = "professor";
                        perfilDao.save(perfilProfessor);
                    }

                }

            });

        }
    }
    public void ImportarServidor(MultipartFile arquivo) throws IOException {
        contLinhaErro = 0;
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(arquivo.getInputStream(), "UTF-8"))) {
            fileReader.lines().forEach((String t)
                    -> {
                String[] csv = t.split(";");
                contLinhaErro++;
                if (contLinhaErro == 1) {

                } else {

                    PerfilProfessor perfilProfessor = new PerfilProfessor();
                    Usuario usuario = new Usuario();
//                    usuario.setPerfil(perfilProfessor);
                    usuario.setEmail(csv[2]);
                    usuario.setPermissao("PROFESSOR");
                    usuario.setUserName(csv[1]);
                    usuario.setPassword(encode.encode("123456"));

                    perfilProfessor.setNome(csv[0]);
                    perfilProfessor.setSiape(Integer.parseInt(csv[1]));
                    
                    usuarioDao.save(usuario);

                    if (csv[3].equalsIgnoreCase("sim")) {
                        perfilProfessor.setCoordenador(true);
                        String tipo = perfilProfessor.getTipo();
                        tipo = "professor";
                        perfilDao.save(perfilProfessor);
                    } else {
                        perfilProfessor.setCoordenador(false);
                        String tipo = perfilProfessor.getTipo();
                        tipo = "professor";
                        perfilDao.save(perfilProfessor);
                    }

                }

            });

        }
    }
}
