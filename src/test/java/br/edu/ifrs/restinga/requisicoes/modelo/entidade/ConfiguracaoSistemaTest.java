/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.requisicoes.modelo.entidade;

import java.util.Date;
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
public class ConfiguracaoSistemaTest {

    public ConfiguracaoSistemaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    ConfiguracaoSistema config = new ConfiguracaoSistema();
    
    @Before
    public void setUp() {
        config.setDataAbertura(new Date("02/05/2012"));
        config.setDataFechamento(new Date("09/08/2020"));
    }

    @After
    public void tearDown() {
    }


    @Test
    public void testGetDataAbertura() {
        System.out.println("getDataAbertura");
        ConfiguracaoSistema instance = new ConfiguracaoSistema();
        instance.setDataAbertura(new Date("02/05/2012"));
        Date result = instance.getDataAbertura();
        assertEquals(config.getDataAbertura(), result);
    }

    @Test
    public void testGetDataFechamento() {
        System.out.println("getDataFechamento");
        ConfiguracaoSistema instance = new ConfiguracaoSistema();
        instance.setDataFechamento(new Date("09/08/2020"));
        Date result = instance.getDataFechamento();
        assertEquals(config.getDataFechamento(), result);
    }


    @Test
    public void testSetDataAbertura() {
        System.out.println("setDataAbertura");
        Date dataAbertura = new Date("09/08/2020");
        ConfiguracaoSistema instance = new ConfiguracaoSistema();
        instance.setDataAbertura(dataAbertura);
    }

    @Test
    public void testSetDataFechamento() {
        System.out.println("setDataFechamento");
        Date dataFechamento = new Date("01/01/2020");;
        ConfiguracaoSistema instance = new ConfiguracaoSistema();
        instance.setDataFechamento(dataFechamento);
    }

}
