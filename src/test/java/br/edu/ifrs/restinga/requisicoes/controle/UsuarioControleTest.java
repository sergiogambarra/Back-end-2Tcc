/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.requisicoes.controle;

import br.edu.ifrs.restinga.requisicoes.modelo.dao.UsuarioDao;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.ServicoCRUD;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;

/**
 *
 * @author jader
 */
public class UsuarioControleTest {

    @Mock
    protected MockMvc mvc;

    @Autowired
    UsuarioDao usuarioDao;

    @MockBean
    UsuarioControle instance;

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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getProductsList() throws Exception {
        String uri = "/api/usuario/alunos/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
    }

    @Test
    public void testCadastroAluno() {
        System.out.println("cadastroAluno");
        Usuario u = new Usuario();
        UsuarioControle controle = new UsuarioControle();
        Usuario user = controle.cadastrar(new Usuario()).getBody();

//        assertEquals(this.usuario, user);
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

    /**
     * Test of getService method, of class UsuarioControle.
     */
    @Test
    public void testGetService() {
        System.out.println("getService");
        UsuarioControle instance = new UsuarioControle();
        ServicoCRUD<Usuario> expResult = null;
        ServicoCRUD<Usuario> result = instance.getService();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
