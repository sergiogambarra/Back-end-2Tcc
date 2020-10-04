/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.requisicoes.controle;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

/**
 *
 * @author jader
 */
public class UsuarioControleTest {
     @Autowired
    
    UsuarioControle instance = new UsuarioControle();   
    Usuario usuario = null;
    
    public UsuarioControleTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Usuario user = new Usuario();
        user.setEmail("rogefhgseç@gmail.com");
        user.setUserName("roger");
        user.setPassword("roger");
        user.setPermissao("ALUNO");
        this.usuario = instance.cadastrar(user).getBody();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCadastroAluno() {
        System.out.println("cadastroAluno");
        Usuario u = new Usuario();
        UsuarioControle controle = new UsuarioControle();
        Usuario user = controle.cadastrar(new Usuario()).getBody();
        
        assertEquals(this.usuario, user);
    }

    @Test
    public void testCadastroServidor() {
        System.out.println("cadastroServidor");
        Usuario u = null;
        UsuarioControle instance = new UsuarioControle();
        ResponseEntity<Usuario> expResult = null;
        ResponseEntity<Usuario> result = instance.cadastroServidor(u);
        assertEquals(expResult, result);
    }

    @Test
    public void testPesquisaLogin() {
        System.out.println("pesquisaLogin");
        String userName = "";
        UsuarioControle instance = new UsuarioControle();
        ResponseEntity<Usuario> expResult = null;
        ResponseEntity<Usuario> result = instance.pesquisaLogin(userName);
        assertEquals(expResult, result);
    }

    @Test
    public void testListaAlunos() {
        System.out.println("listaAlunos");
        UsuarioControle instance = new UsuarioControle();
        ResponseEntity<Usuario> expResult = null;
        ResponseEntity<Usuario> result = instance.listaAlunos();
        assertEquals(expResult, result);
    }

    @Test
    public void testListaProfessor() {
        System.out.println("listaProfessor");
        UsuarioControle instance = new UsuarioControle();
        ResponseEntity<Usuario> expResult = null;
        ResponseEntity<Usuario> result = instance.listaProfessor();
        assertEquals(expResult, result);
    }

    @Test
    public void testListaServidor() {
        System.out.println("listaServidor");
        UsuarioControle instance = new UsuarioControle();
        ResponseEntity<Usuario> expResult = null;
        ResponseEntity<Usuario> result = instance.listaServidor();
        assertEquals(expResult, result);
    }

    @Test
    public void testListaMatricula() {
        System.out.println("listaMatricula");
        int matricula = 0;
        UsuarioControle instance = new UsuarioControle();
        ResponseEntity<Usuario> expResult = null;
        ResponseEntity<Usuario> result = instance.listaMatricula(matricula);
        assertEquals(expResult, result);
    }

    @Test
    public void testListaSiape() {
        System.out.println("listaSiape");
        Integer siape = null;
        UsuarioControle instance = new UsuarioControle();
        ResponseEntity<Usuario> expResult = null;
        ResponseEntity<Usuario> result = instance.listaSiape(siape);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAutenticado() {
        System.out.println("getAutenticado");
        Authentication authentication = null;
        UsuarioControle instance = new UsuarioControle();
        ResponseEntity<Usuario> expResult = null;
        ResponseEntity<Usuario> result = instance.getAutenticado(authentication);
        assertEquals(expResult, result);
    }

    @Test
    public void testTrocaSenha() {
        System.out.println("trocaSenha");
        long id = 0L;
        Usuario u = null;
        UsuarioControle instance = new UsuarioControle();
        ResponseEntity<Usuario> expResult = null;
        ResponseEntity<Usuario> result = instance.trocaSenha(id, u);
        assertEquals(expResult, result);
    }

    @Test
    public void testListarUsuariosPaginacao() {
        System.out.println("listarUsuariosPaginacao");
        Pageable p = null;
        String tipo = "";
        UsuarioControle instance = new UsuarioControle();
        ResponseEntity<Usuario> expResult = null;
        ResponseEntity<Usuario> result = instance.listarUsuariosPaginacao(p, tipo);
        assertEquals(expResult, result);
    }

    @Test
    public void testListaPesquisaNome() {
        System.out.println("listaPesquisaNome");
        String nome = "";
        UsuarioControle instance = new UsuarioControle();
        ResponseEntity<Usuario> expResult = null;
        ResponseEntity<Usuario> result = instance.listaPesquisaNome(nome);
        assertEquals(expResult, result);
    }

}
