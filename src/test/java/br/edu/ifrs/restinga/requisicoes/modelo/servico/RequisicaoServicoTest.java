/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.requisicoes.modelo.servico;

import br.edu.ifrs.restinga.requisicoes.modelo.dao.PaginacaoRepository;
import br.edu.ifrs.restinga.requisicoes.modelo.dto.FiltroDto;
import br.edu.ifrs.restinga.requisicoes.modelo.dto.RequisicaoDto;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Requisicao;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.RequisicaoAproveitamento;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.RequisicaoCertificacao;
import br.edu.ifrs.restinga.requisicoes.modelo.rn.RegraNenocio;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author jader
 */
public class RequisicaoServicoTest {
    
    public RequisicaoServicoTest() {
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
     * Test of getDAO method, of class RequisicaoServico.
     */
    @Test
    public void testGetDAO() {
        System.out.println("getDAO");
        RequisicaoServico instance = new RequisicaoServico();
        PaginacaoRepository<Requisicao, Long> expResult = null;
        PaginacaoRepository<Requisicao, Long> result = instance.getDAO();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testRn() {
        System.out.println("rn");
        RequisicaoServico instance = new RequisicaoServico();
        RegraNenocio<Requisicao> expResult = null;
        RegraNenocio<Requisicao> result = instance.rn();
        assertEquals(expResult, result);
    }

    @Test
    public void testCadastrar() {
        System.out.println("cadastrar");
        Requisicao entidade = null;
        RequisicaoServico instance = new RequisicaoServico();
        Requisicao expResult = null;
        Requisicao result = instance.cadastrar(entidade);
        assertEquals(expResult, result);
    }

    @Test
    public void testListarAproveitamento() {
        System.out.println("listarAproveitamento");
        Pageable page = null;
        RequisicaoServico instance = new RequisicaoServico();
        Page<RequisicaoAproveitamento> expResult = null;
        Page<RequisicaoAproveitamento> result = instance.listarAproveitamento(page);
        assertEquals(expResult, result);
    }

    @Test
    public void testListarCertificacao() {
        System.out.println("listarCertificacao");
        Pageable page = null;
        Requisicao r = new RequisicaoCertificacao();
        r.setDeferido("sim");
        RequisicaoServico instance = new RequisicaoServico();
        instance.cadastrar(r);
        Page<RequisicaoCertificacao> expResult = null;
        Page<RequisicaoCertificacao> result = instance.listarCertificacao(page);
        assertEquals(expResult, result);
    }

    @Test
    public void testListarCertificacaoSolicitante() {
        System.out.println("listarCertificacaoSolicitante");
        Long id = null;
        RequisicaoServico instance = new RequisicaoServico();
        List<Requisicao> expResult = null;
        List<Requisicao> result = instance.listarCertificacaoSolicitante(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testAtualizar() {
        System.out.println("atualizar");
        Requisicao entidade = null;
        RequisicaoServico instance = new RequisicaoServico();
        Requisicao expResult = null;
        Requisicao result = instance.atualizar(entidade);
        assertEquals(expResult, result);
    }

    @Test
    public void testListarPorProfessor() {
        System.out.println("listarPorProfessor");
        Long id = null;
        String tipo = "";
        Pageable p = null;
        RequisicaoServico instance = new RequisicaoServico();
        Page<Requisicao> expResult = null;
        Page<Requisicao> result = instance.listarPorProfessor(id, tipo, p);
        assertEquals(expResult, result);
    }

    @Test
    public void testListarData() {
        System.out.println("listarData");
        Date i = null;
        Date f = null;
        Pageable p = null;
        RequisicaoServico instance = new RequisicaoServico();
        Page<Requisicao> expResult = null;
        Page<Requisicao> result = instance.listarData(i, f, p);
        assertEquals(expResult, result);
    }

    @Test
    public void testListarDataRelatorio() {
        System.out.println("listarDataRelatorio");
        Date i = null;
        Date f = null;
        RequisicaoServico instance = new RequisicaoServico();
        List<Requisicao> expResult = null;
        List<Requisicao> result = instance.listarDataRelatorio(i, f);
        assertEquals(expResult, result);
    }

    @Test
    public void testListarRequisicaoAluno() {
        System.out.println("listarRequisicaoAluno");
        Long id = null;
        Pageable p = null;
        RequisicaoServico instance = new RequisicaoServico();
        Page<Requisicao> expResult = null;
        Page<Requisicao> result = instance.listarRequisicaoAluno(id, p);
        assertEquals(expResult, result);
    }

    @Test
    public void testListarStatus() {
        System.out.println("listarStatus");
        String status = "";
        Pageable p = null;
        RequisicaoServico instance = new RequisicaoServico();
        Page<Requisicao> expResult = null;
        Page<Requisicao> result = instance.listarStatus(status, p);
        assertEquals(expResult, result);
    }

    @Test
    public void testListarRequisicaoAlunoAproveitamento() {
        System.out.println("listarRequisicaoAlunoAproveitamento");
        Long id = null;
        Pageable p = null;
        RequisicaoServico instance = new RequisicaoServico();
        Page<RequisicaoAproveitamento> expResult = null;
        Page<RequisicaoAproveitamento> result = instance.listarRequisicaoAlunoAproveitamento(id, p);
        assertEquals(expResult, result);
    }

    @Test
    public void testListarRequisicaoAlunoCertificacao() {
        System.out.println("listarRequisicaoAlunoCertificacao");
        Long id = null;
        Pageable p = null;
        RequisicaoServico instance = new RequisicaoServico();
        Page<RequisicaoCertificacao> expResult = null;
        Page<RequisicaoCertificacao> result = instance.listarRequisicaoAlunoCertificacao(id, p);
        assertEquals(expResult, result);
    }

    @Test
    public void testListarRequisicaoCurso() {
        System.out.println("listarRequisicaoCurso");
        Long id = null;
        Pageable p = null;
        RequisicaoServico instance = new RequisicaoServico();
        Page<Requisicao> expResult = null;
        Page<Requisicao> result = instance.listarRequisicaoCurso(id, p);
        assertEquals(expResult, result);
    }

    @Test
    public void testFiltrarRequisicao() {
        System.out.println("filtrarRequisicao");
        FiltroDto filtro = null;
        RequisicaoServico instance = new RequisicaoServico();
        List<RequisicaoDto> expResult = null;
        List<RequisicaoDto> result = instance.filtrarRequisicao(filtro);
        assertEquals(expResult, result);
    }

    @Test
    public void testListarRequisicaoCoordenador() {
        System.out.println("listarRequisicaoCoordenador");
        Long id = null;
        Pageable p = null;
        RequisicaoServico instance = new RequisicaoServico();
        Page<RequisicaoCertificacao> expResult = null;
        Page<RequisicaoCertificacao> result = instance.listarRequisicaoCoordenador(id, p);
        assertEquals(expResult, result);
    }

    @Test
    public void testListarRequisicaoCoordenadorAproveitamento() {
        System.out.println("listarRequisicaoCoordenadorAproveitamento");
        Long id = null;
        Pageable p = null;
        RequisicaoServico instance = new RequisicaoServico();
        Page<RequisicaoAproveitamento> expResult = null;
        Page<RequisicaoAproveitamento> result = instance.listarRequisicaoCoordenadorAproveitamento(id, p);
        assertEquals(expResult, result);
    }
    
}
