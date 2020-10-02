/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.requisicoes.modelo.servico;

import br.edu.ifrs.restinga.requisicoes.modelo.dao.PaginacaoRepository;
import br.edu.ifrs.restinga.requisicoes.modelo.dto.UsuarioDto;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
import br.edu.ifrs.restinga.requisicoes.modelo.rn.RegraNenocio;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author jader
 */
public class UsuarioServicoTest {
    
    public UsuarioServicoTest() {
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

    /**
     * Test of getDAO method, of class UsuarioServico.
     */
    @Test
    public void testGetDAO() {
        System.out.println("getDAO");
        UsuarioServico instance = new UsuarioServico();
        PaginacaoRepository<Usuario, Long> expResult = null;
        PaginacaoRepository<Usuario, Long> result = instance.getDAO();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rn method, of class UsuarioServico.
     */
    @Test
    public void testRn() {
        System.out.println("rn");
        UsuarioServico instance = new UsuarioServico();
        RegraNenocio<Usuario> expResult = null;
        RegraNenocio<Usuario> result = instance.rn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadUserByUsername method, of class UsuarioServico.
     */
    @Test
    public void testLoadUserByUsername() {
        System.out.println("loadUserByUsername");
        String username = "";
        UsuarioServico instance = new UsuarioServico();
        UserDetails expResult = null;
        UserDetails result = instance.loadUserByUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of autenticar method, of class UsuarioServico.
     */
    @Test
    public void testAutenticar() {
        System.out.println("autenticar");
        UsuarioDto user = null;
        UsuarioServico instance = new UsuarioServico();
        Usuario expResult = null;
        Usuario result = instance.autenticar(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cadastrar method, of class UsuarioServico.
     */
    @Test
    public void testCadastrar() {
        System.out.println("cadastrar");
        Usuario u = null;
        UsuarioServico instance = new UsuarioServico();
        Usuario expResult = null;
        Usuario result = instance.cadastrar(u);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pesquisaLogin method, of class UsuarioServico.
     */
    @Test
    public void testPesquisaLogin() {
        System.out.println("pesquisaLogin");
        String nome = "";
        UsuarioServico instance = new UsuarioServico();
        Usuario expResult = null;
        Usuario result = instance.pesquisaLogin(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarAluno method, of class UsuarioServico.
     */
    @Test
    public void testListarAluno() {
        System.out.println("listarAluno");
        UsuarioServico instance = new UsuarioServico();
        List<Usuario> expResult = null;
        List<Usuario> result = instance.listarAluno();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarProfessor method, of class UsuarioServico.
     */
    @Test
    public void testListarProfessor() {
        System.out.println("listarProfessor");
        UsuarioServico instance = new UsuarioServico();
        List<Usuario> expResult = null;
        List<Usuario> result = instance.listarProfessor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarServidor method, of class UsuarioServico.
     */
    @Test
    public void testListarServidor() {
        System.out.println("listarServidor");
        UsuarioServico instance = new UsuarioServico();
        List<Usuario> expResult = null;
        List<Usuario> result = instance.listarServidor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizar method, of class UsuarioServico.
     */
    @Test
    public void testAtualizar() {
        System.out.println("atualizar");
        Usuario entidade = null;
        UsuarioServico instance = new UsuarioServico();
        Usuario expResult = null;
        Usuario result = instance.atualizar(entidade);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizarSenha method, of class UsuarioServico.
     */
    @Test
    public void testAtualizarSenha() {
        System.out.println("atualizarSenha");
        Usuario u = null;
        UsuarioServico instance = new UsuarioServico();
        Usuario expResult = null;
        Usuario result = instance.atualizarSenha(u);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listaUsuarioMatricula method, of class UsuarioServico.
     */
    @Test
    public void testListaUsuarioMatricula() {
        System.out.println("listaUsuarioMatricula");
        int matricula = 0;
        UsuarioServico instance = new UsuarioServico();
        Usuario expResult = null;
        Usuario result = instance.listaUsuarioMatricula(matricula);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listaProfessorSiape method, of class UsuarioServico.
     */
    @Test
    public void testListaProfessorSiape() {
        System.out.println("listaProfessorSiape");
        Integer siape = null;
        UsuarioServico instance = new UsuarioServico();
        Usuario expResult = null;
        Usuario result = instance.listaProfessorSiape(siape);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarPaginacao method, of class UsuarioServico.
     */
    @Test
    public void testListarPaginacao() {
        System.out.println("listarPaginacao");
        Pageable p = null;
        String tipo = "";
        UsuarioServico instance = new UsuarioServico();
        Page<Usuario> expResult = null;
        Page<Usuario> result = instance.listarPaginacao(p, tipo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarPesquisaNome method, of class UsuarioServico.
     */
    @Test
    public void testListarPesquisaNome() {
        System.out.println("listarPesquisaNome");
        String nome = "";
        UsuarioServico instance = new UsuarioServico();
        List<Usuario> expResult = null;
        List<Usuario> result = instance.listarPesquisaNome(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
