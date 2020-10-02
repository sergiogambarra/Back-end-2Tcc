/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.requisicoes.controle;

import br.edu.ifrs.restinga.requisicoes.modelo.dto.TokenDto;
import br.edu.ifrs.restinga.requisicoes.modelo.dto.UsuarioDto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jader
 */
public class LoginControleTest {
    
    public LoginControleTest() {
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
     * Test of autenticar method, of class LoginControle.
     */
    @Test
    public void testAutenticar() {
        System.out.println("autenticar");
        UsuarioDto user = null;
        LoginControle instance = new LoginControle();
        TokenDto expResult = null;
        TokenDto result = instance.autenticar(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
