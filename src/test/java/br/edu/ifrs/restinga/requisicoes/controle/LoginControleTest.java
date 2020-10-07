/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.requisicoes.controle;

import br.edu.ifrs.restinga.requisicoes.modelo.dto.TokenDto;
import br.edu.ifrs.restinga.requisicoes.modelo.dto.UsuarioDto;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
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

    Usuario u;

    @Before
    public void setUp() {
        u = new Usuario();
        
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAutenticar() {
        System.out.println("autenticar");
        UsuarioDto user = null;
        user.setUserName("jader");
        LoginControle instance = new LoginControle();
        TokenDto expResult = null;
        
        TokenDto result = instance.autenticar(user);
        assertEquals(expResult, result);
    }

}
