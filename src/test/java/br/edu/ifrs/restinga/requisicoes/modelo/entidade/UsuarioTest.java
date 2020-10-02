/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.requisicoes.modelo.entidade;

import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author jader
 */
public class UsuarioTest {
    
    public UsuarioTest() {
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
    u.setPassword("jader");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPassword method, of class Usuario.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Usuario instance = new Usuario();
        String expResult = u.getPassword();
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsername method, of class Usuario.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Usuario instance = new Usuario();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAccountNonExpired method, of class Usuario.
     */
    @Test
    public void testIsAccountNonExpired() {
        System.out.println("isAccountNonExpired");
        Usuario instance = new Usuario();
        boolean expResult = false;
        boolean result = instance.isAccountNonExpired();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAccountNonLocked method, of class Usuario.
     */
    @Test
    public void testIsAccountNonLocked() {
        System.out.println("isAccountNonLocked");
        Usuario instance = new Usuario();
        boolean expResult = false;
        boolean result = instance.isAccountNonLocked();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isCredentialsNonExpired method, of class Usuario.
     */
    @Test
    public void testIsCredentialsNonExpired() {
        System.out.println("isCredentialsNonExpired");
        Usuario instance = new Usuario();
        boolean expResult = false;
        boolean result = instance.isCredentialsNonExpired();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEnabled method, of class Usuario.
     */
    @Test
    public void testIsEnabled() {
        System.out.println("isEnabled");
        Usuario instance = new Usuario();
        boolean expResult = false;
        boolean result = instance.isEnabled();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAuthorities method, of class Usuario.
     */
    @Test
    public void testGetAuthorities() {
        System.out.println("getAuthorities");
        Usuario instance = new Usuario();
        Collection<? extends GrantedAuthority> expResult = null;
        Collection<? extends GrantedAuthority> result = instance.getAuthorities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Usuario.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Usuario instance = new Usuario();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPermissao method, of class Usuario.
     */
    @Test
    public void testGetPermissao() {
        System.out.println("getPermissao");
        Usuario instance = new Usuario();
        String expResult = "";
        String result = instance.getPermissao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Usuario.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Usuario instance = new Usuario();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAlterouSenha method, of class Usuario.
     */
    @Test
    public void testGetAlterouSenha() {
        System.out.println("getAlterouSenha");
        Usuario instance = new Usuario();
        Boolean expResult = null;
        Boolean result = instance.getAlterouSenha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPerfil method, of class Usuario.
     */
    @Test
    public void testGetPerfil() {
        System.out.println("getPerfil");
        Usuario instance = new Usuario();
        Perfil expResult = null;
        Perfil result = instance.getPerfil();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Usuario.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        Usuario instance = new Usuario();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserName method, of class Usuario.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String userName = "";
        Usuario instance = new Usuario();
        instance.setUserName(userName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class Usuario.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        Usuario instance = new Usuario();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPermissao method, of class Usuario.
     */
    @Test
    public void testSetPermissao() {
        System.out.println("setPermissao");
        String permissao = "";
        Usuario instance = new Usuario();
        instance.setPermissao(permissao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Usuario.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Usuario instance = new Usuario();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAlterouSenha method, of class Usuario.
     */
    @Test
    public void testSetAlterouSenha() {
        System.out.println("setAlterouSenha");
        Boolean alterouSenha = null;
        Usuario instance = new Usuario();
        instance.setAlterouSenha(alterouSenha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPerfil method, of class Usuario.
     */
    @Test
    public void testSetPerfil() {
        System.out.println("setPerfil");
        Perfil perfil = null;
        Usuario instance = new Usuario();
        instance.setPerfil(perfil);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Usuario.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Usuario instance = new Usuario();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of canEqual method, of class Usuario.
     */
    @Test
    public void testCanEqual() {
        System.out.println("canEqual");
        Object other = null;
        Usuario instance = new Usuario();
        boolean expResult = false;
        boolean result = instance.canEqual(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Usuario.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Usuario instance = new Usuario();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Usuario.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Usuario instance = new Usuario();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
