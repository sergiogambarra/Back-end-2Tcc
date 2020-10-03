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

/**
 *
 * @author jader
 */
public class RequisicaoAproveitamentoTest {
    
    public RequisicaoAproveitamentoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    RequisicaoAproveitamento r;
    
    @Before
    public void setUp() {
        r = new RequisicaoAproveitamento();
        r.setTipo("APROVEITAMENTO");
        r.setDisciplinasCursadasAnterior("analise");
        r.setDisciplinaSolicitada("progamação");
        r.setDeferido("deferido");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        RequisicaoAproveitamento instance = new RequisicaoAproveitamento();
        instance.setTipo("APROVEITAMENTO");
        String result = instance.getTipo();
        assertEquals(r.getTipo(), result);
    }
    
    @Test
    public void testGetDisciplinasCursadasAnterior() {
        System.out.println("getDisciplinasCursadasAnterior");
        RequisicaoAproveitamento instance = new RequisicaoAproveitamento();
        instance.setDisciplinasCursadasAnterior("analise");
        String result = instance.getDisciplinasCursadasAnterior();
        assertEquals(r.getDisciplinasCursadasAnterior(), result);
    }
    
    @Test
    public void testGetDisciplinaSolicitada() {
        RequisicaoAproveitamento instance = new RequisicaoAproveitamento();
        instance.setDisciplinaSolicitada("progamação");
        Disciplina result = instance.getDisciplinaSolicitada();
        assertEquals(r.getDisciplinasCursadasAnterior(), result);
    }
    
}
