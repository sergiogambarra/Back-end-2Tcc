package br.edu.ifrs.restinga.requisicoes.modelo.entidade;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CursoTest {

    public CursoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    Curso curso = new Curso();

    @Before
    public void setUp() {
        curso.setId(1l);
        curso.setNome("Educação Física");
        curso.setUsuario(new Usuario(1l, "Roberto"));

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetId() {
        System.out.println("getId");
        Curso instance = new Curso();
        instance.setId(1l);
        Long result = instance.getId();
        assertEquals(curso.getId(), result);
    }

    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Curso instance = new Curso();
        instance.setNome("Educação Física");
        String result = instance.getNome();
        assertEquals(curso.getNome(), result);
    }

    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        Curso instance = new Curso();
        instance.setUsuario(new Usuario(1l, "Roberto"));
        Usuario result = instance.getUsuario();
        assertEquals(curso.getUsuario(), result);
    }

    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 5l;
        Curso instance = new Curso();
        instance.setId(id);
    }

    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "Joaquim";
        Curso instance = new Curso();
        instance.setNome(nome);
    }

    @Test
    public void testSetUsuario() {
        System.out.println("setUsuario");
        Usuario usuario = new Usuario(8l, "Valdir da Silva");
        Curso instance = new Curso();
        instance.setUsuario(usuario);
    }

}
