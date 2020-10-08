package br.edu.ifrs.restinga.requisicoes.modelo.entidade;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DisciplinaTest {
    
    public DisciplinaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    Disciplina disciplina = new Disciplina();
    
    @Before
    public void setUp() {
        disciplina.setId(1l);
        disciplina.setNome("Teste");
        disciplina.setCargaHoraria(50);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetId() {
        System.out.println("getId");
        Disciplina instance = new Disciplina();
        instance.setId(1l);
        Long result = instance.getId();
        assertEquals(disciplina.getId(), result);
    }

    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Disciplina instance = new Disciplina();
        instance.setNome("Teste");
        String result = instance.getNome();
        assertEquals(disciplina.getNome(), result);
    }

    @Test
    public void testGetCargaHoraria() {
        System.out.println("getCargaHoraria");
        Disciplina instance = new Disciplina();
        instance.setCargaHoraria(50);
        int result = instance.getCargaHoraria();
        assertEquals(disciplina.getCargaHoraria(), result);
    }

    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 4l;
        Disciplina instance = new Disciplina();
        instance.setId(id);
    }

    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "Teste";
        Disciplina instance = new Disciplina();
        instance.setNome(nome);
    }
    
    @Test
    public void testSetCargaHoraria() {
        System.out.println("setCargaHoraria");
        int cargaHoraria = 50;
        Disciplina instance = new Disciplina();
        instance.setCargaHoraria(cargaHoraria);
    }

}
