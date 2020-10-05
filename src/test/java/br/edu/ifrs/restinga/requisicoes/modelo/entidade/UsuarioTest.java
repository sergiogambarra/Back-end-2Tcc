/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.requisicoes.modelo.entidade;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class UsuarioTest {
    
    public UsuarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    Usuario usuario;
    
    @Before
    public void setUp() {
        usuario = new Usuario();
        usuario.setAlterouSenha(false);
        usuario.setEmail("jader.mmoura@gmail.com");
        usuario.setPassword("123");
        usuario.setId(1l);
        usuario.setPerfil(new PerfilAluno() {});
        usuario.setPermissao("Aluno");
        usuario.setUserName("jader");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Usuario instance = new Usuario();
        instance.setPassword("123");
        String result = instance.getPassword();
        assertEquals(usuario.getPassword(), result);
    }
    
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Usuario instance = new Usuario();
        instance.setUserName("jader");
        String result = instance.getUsername();
        assertEquals(usuario.getUsername(), result);
    }

    @Test
    public void testGetId() {
        System.out.println("getId");
        Usuario instance = new Usuario();
        instance.setId(1l);
        Long result = instance.getId();
        assertEquals(usuario.getId(), result);
    }

    @Test
    public void testGetPermissao() {
        System.out.println("getPermissao");
        Usuario instance = new Usuario();
        instance.setPermissao("Aluno");
        String result = instance.getPermissao();
        assertEquals(usuario.getPermissao(), result);
    }

    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Usuario instance = new Usuario();
        instance.setEmail("jader.mmoura@gmail.com");
        String result = instance.getEmail();
        assertEquals(usuario.getEmail(), result);
    }

    @Test
    public void testGetAlterouSenha() {
        System.out.println("getAlterouSenha");
        Usuario instance = new Usuario();
        instance.setAlterouSenha(false);
        Boolean result = instance.getAlterouSenha();
        assertEquals(usuario.getAlterouSenha(), result);
    }

    @Test
    public void testGetPerfil() {
        System.out.println("getPerfil");
        Usuario instance = new Usuario();
        instance.setPerfil(new PerfilAluno());
        Perfil result = instance.getPerfil();
        assertEquals(usuario.getPerfil(), result);
    }

    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 5l;
        Usuario instance = new Usuario();
        instance.setId(id);
        assertEquals(id, instance.getId());
    }

    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String userName = "Alessandro";
        Usuario instance = new Usuario();
        instance.setUserName(userName);
        assertEquals(userName, instance.getUsername());
    }

    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "123456";
        Usuario instance = new Usuario();
        instance.setPassword(password);
        assertEquals(password, instance.getPassword());
    }

    @Test
    public void testSetPermissao() {
        System.out.println("setPermissao");
        String permissao = "ALUNO";
        Usuario instance = new Usuario();
        instance.setPermissao(permissao);
        assertEquals(permissao, instance.getPermissao());
    }

    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Usuario instance = new Usuario();
        instance.setEmail(email);
        assertEquals(email, instance.getEmail());
        
    }

    @Test
    public void testSetAlterouSenha() {
        System.out.println("setAlterouSenha");
        Boolean alterouSenha = null;
        Usuario instance = new Usuario();
        instance.setAlterouSenha(alterouSenha);
        assertEquals(alterouSenha, instance.getAlterouSenha());
    }

    @Test
    public void testSetPerfil() {
        System.out.println("setPerfil");
        PerfilProfessor perfilProfessor = new PerfilProfessor(Long.MIN_VALUE, Integer.SIZE, true);
        Usuario instance = new Usuario();
        instance.setPerfil(new PerfilProfessor(Long.MIN_VALUE, Integer.SIZE, true));
        assertEquals(perfilProfessor, instance.getPerfil());
    }

}
