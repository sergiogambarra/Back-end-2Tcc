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
import br.edu.ifrs.restinga.requisicoes.modelo.dao.PerfilServidorDao;
import br.edu.ifrs.restinga.requisicoes.modelo.dao.UsuarioDao;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Curso;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Disciplina;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.PerfilProfessor;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.PerfilServidor;
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
    PasswordEncoder encode;

    @Autowired
    PerfilServidorDao perfilServidorDao;

    @Autowired
    PerfilProfessorDao perfilProfessorDao;

    int contLinhaErro = 0;

    public void importacaoCsvCurso(MultipartFile arquivo) throws IOException {
        contLinhaErro = 0;
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(arquivo.getInputStream(), "UTF-8"))) {
            fileReader.lines().forEach((t)
                    -> {
                String[] csv = t.split(",");
                contLinhaErro++;
                Boolean verifica = false;
                if (contLinhaErro == 1) {

                } else {
                    Curso curso = new Curso(csv[0]);
                    List<Usuario> usuarios = usuarioDao.findByNome(csv[1]);
                    Iterable<Curso> todosCursos = cursoDao.findAll();

                    for (Curso c : todosCursos) {
                        verifica = false;
                        if (c.getNome().equalsIgnoreCase(curso.getNome()) == true) {
                            System.out.println("Não foi possível cadastrar esse curso " + "linha " + contLinhaErro + " já possui curso com esse nome.");
                            verifica = true;
                            return;
                        }
                    }
                    if (!usuarios.isEmpty() && !"".equals(curso.getNome()) && verifica == false) {
                        Usuario usuario = usuarios.get(0);
                        PerfilProfessor perfil = (PerfilProfessor) usuario.getPerfil();
                        perfil.setCoordenador(true);
                        curso.setUsuario(usuario);
                        cursoDao.save(curso);

                    } else {
                        System.out.println("Não foi possível cadastrar linha " + contLinhaErro + " campo está vazio ou coordenador não está cadastrado.");
                        return;
                    }

                }
            });

        }
    }

    public void ImportarDisciplinas(MultipartFile arquivo) throws IOException {
        contLinhaErro = 0;
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(arquivo.getInputStream(), "UTF-8"))) {
            fileReader.lines().forEach((String t)
                    -> {
                Disciplina disciplina = new Disciplina();
                String[] csv = t.split(",");
                contLinhaErro++;
                Boolean verifica = false;
                if (contLinhaErro == 1) {

                } else if (csv.length < 3) {
                    System.out.println("Não foi possível cadastrar linha " + contLinhaErro + " campo vazio ou carga horária não está correta. ");
                } else if (Integer.parseInt(csv[1]) < 15 || Integer.parseInt(csv[1]) > 300 || csv[0].length() > 45 || "".equals(csv[0].trim())) {
                    System.out.println("Não foi possível cadastrar linha " + contLinhaErro + " campo vazio ou carga horária não está correta. ");
                } else {
                    Curso curso = cursoDao.findByNome(csv[2]);
                    if (curso != null) {
                        Iterable<Disciplina> disciplinasSalva = disciplinaDao.findAll();
                        if (disciplinasSalva == null) {
                            verifica = true;
                        }
                        for (Disciplina disciplina1 : disciplinasSalva) {
                            verifica = true;
                            if (disciplina1.getNome().equals(csv[0])) {
                                System.out.println("Disciplina já cadastrada nesse curso " + " da linha " + contLinhaErro);
                                verifica = false;
                                return;
                            }

                        }
                        if (verifica) {

                            disciplina.setNome(csv[0]);
                            disciplina.setCargaHoraria(Integer.parseInt(csv[1]));
                            curso.getDisciplinas().add(disciplina);
                            disciplinaDao.save(disciplina);
                            cursoDao.save(curso);

                        }
                    } else {
                        System.out.println("Não foi possível cadastrar linha " + contLinhaErro + " curso não cadastrado. ");
                    }
                }

            });

        }
    }

    public void ImportarUsuarios(MultipartFile arquivo) throws IOException {
        contLinhaErro = 0;
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(arquivo.getInputStream(), "UTF-8"))) {
            fileReader.lines().forEach((String t)
                    -> {
                String[] csv = t.split(",");
                contLinhaErro++;
                if (contLinhaErro == 1) {

                } else {
                    Usuario usuario = new Usuario();
                    Iterable<Usuario> usuarios = usuarioDao.findAll();

                    PerfilServidor perfilServidor1 = new PerfilServidor((csv[1]), csv[0]);
                    Boolean verificaEmail = false;
                    Boolean verificaSiape = false;
                    Iterable<PerfilServidor> perfilServidor = perfilServidorDao.findAll();
                    Iterable<PerfilProfessor> perfilProfessor = perfilProfessorDao.findAll();

                    for (PerfilServidor perfilServidor2 : perfilServidor) {
                        if (perfilServidor2.getSiape().equals(csv[1])) {
                            System.out.println("Não foi possível cadastrar SIAPE já cadastrado linha " + contLinhaErro);
                            verificaSiape = true;
                            return;
                        }
                        for (Usuario usuario1 : usuarios) {
                            if (usuario1.getEmail().equalsIgnoreCase(csv[2])) {
                                System.out.println("Não foi possível cadastrar EMAIL já cadastrado linha " + contLinhaErro);
                                verificaEmail = true;
                                return;

                            }

                        }
                        for (PerfilProfessor perfilProfessor1 : perfilProfessor) {
                            if (perfilProfessor1.getSiape().equals(csv[1])) {
                                System.out.println("Não foi possível cadastrar SIAPE já cadastrado linha " + contLinhaErro);
                                verificaSiape = true;
                                return;
                            }
                    }
                        }

                    if (csv[4].equalsIgnoreCase("professor") && verificaEmail == false && verificaSiape == false) {
                        usuario.setPermissao("PROFESSOR");
                        PerfilProfessor perfil = new PerfilProfessor((csv[1]), csv[0]);
                        if (csv[3].equalsIgnoreCase("sim")) {
                            perfil.setCoordenador(true);
                        } else {
                            perfil.setCoordenador(false);
                        }
                        usuario.setPerfil(perfilDao.save(perfil));
                        usuario.setEmail(csv[2]);
                    } else if (verificaEmail == false && verificaSiape == false) {
                        usuario.setPermissao("SERVIDOR");
                        perfilServidor1.setCargo("SERVIDOR");
                        usuario.setEmail(csv[2]);
                        usuario.setPerfil(perfilDao.save(perfilServidor1));

                    }
                    if (verificaEmail == false && verificaSiape == false) {

                        usuario.setUserName(csv[1]);
                        usuario.setPassword(encode.encode("123456"));

                        usuarioDao.save(usuario);
                    }
                }
            });

        }
    }
}
