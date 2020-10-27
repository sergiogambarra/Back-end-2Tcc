package br.edu.ifrs.restinga.requisicoes.modelo.entidade;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RequisicaoTest {

    RequisicaoAproveitamento requisição = new RequisicaoAproveitamento();
    Requisicao testeRequisiçãoAproveitamento = new RequisicaoAproveitamento();

    public RequisicaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        requisição.setId(1l);
        requisição.setParecerServidor("documentação está correta");
        requisição.setDeferido("sim");
        requisição.setDisciplinaSolicitada(new Disciplina("Progamação", 20));
        requisição.setDisciplinasCursadasAnterior("Libras");
        requisição.setTipo("Aproveitamento");
        requisição.setUsuario(new Usuario(1l, "Jader"));
        requisição.setParecerProfessor("reprovado");
        requisição.setParecerCoordenador("reprovado na solicitação");
        requisição.setResponsavelPelaRequisicao("Ensino");
        requisição.setProfessor(new Usuario(1l, "Pedro"));
        

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        testeRequisiçãoAproveitamento.setTipo("Aproveitamento");
        String result = testeRequisiçãoAproveitamento.getTipo();
        assertEquals(requisição.getTipo(), result);
    }

    @Test
    public void testGetId() {
        System.out.println("getId");
        testeRequisiçãoAproveitamento.setId(1l);
        Long result = testeRequisiçãoAproveitamento.getId();
        assertEquals(requisição.getId(), result);
    }


    @Test
    public void testGetParecerServidor() {
        System.out.println("getParecerServidor");
        testeRequisiçãoAproveitamento.setParecerServidor("documentação está correta");
        String result = testeRequisiçãoAproveitamento.getParecerServidor();
        assertEquals(requisição.getParecerServidor(), result);
    }

    @Test
    public void testGetParecerProfessor() {
        System.out.println("getParecerProfessor");
        testeRequisiçãoAproveitamento.setParecerProfessor("reprovado");
        String result = testeRequisiçãoAproveitamento.getParecerProfessor();
        assertEquals(requisição.getParecerProfessor(), result);
    }

    @Test
    public void testGetParecerCoordenador() {
        System.out.println("getParecerCoordenador");
        testeRequisiçãoAproveitamento.setParecerCoordenador("reprovado na solicitação");
        String result = testeRequisiçãoAproveitamento.getParecerCoordenador();
        assertEquals(requisição.getParecerCoordenador(), result);
    }

    @Test
    public void testGetDeferido() {
        System.out.println("getDeferido");
        testeRequisiçãoAproveitamento.setDeferido("sim");
        String result = testeRequisiçãoAproveitamento.getDeferido();
        assertEquals(requisição.getDeferido(), result);
    }

    @Test
    public void testGetResponsavelPelaRequisicao() {
        System.out.println("getResponsavelPelaRequisicao");
        testeRequisiçãoAproveitamento.setResponsavelPelaRequisicao("Ensino");
        String result = testeRequisiçãoAproveitamento.getResponsavelPelaRequisicao();
        assertEquals(requisição.getResponsavelPelaRequisicao(), result);
    }

    @Test
    public void testGetDisciplinaSolicitada() {
        System.out.println("getDisciplinaSolicitada");
        testeRequisiçãoAproveitamento.setDisciplinaSolicitada(new Disciplina("Progamação", 20));
        Disciplina result = testeRequisiçãoAproveitamento.getDisciplinaSolicitada();
        assertEquals(requisição.getDisciplinaSolicitada(), result);
    }

    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        testeRequisiçãoAproveitamento.setUsuario(new Usuario(1l, "Jader"));
        Usuario result = testeRequisiçãoAproveitamento.getUsuario();
        assertEquals(requisição.getUsuario(), result);
    }


    @Test
    public void testGetProfessor() {
        System.out.println("getProfessor");
        testeRequisiçãoAproveitamento.setProfessor(new Usuario(1l, "Pedro"));
        Usuario result = testeRequisiçãoAproveitamento.getProfessor();
        assertEquals(requisição.getProfessor(), result);
    }

    @Test
    public void testSetTipo() {
        System.out.println("setTipo");
        String tipo = "Aproveitamento";
        testeRequisiçãoAproveitamento.setTipo(tipo);
    }

    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 125555l;
        testeRequisiçãoAproveitamento.setId(id);
    }

    @Test
    public void testSetDataRequisicao() {
        System.out.println("setDataRequisicao");
        Date dataRequisicao = new Date();
        dataRequisicao.setDate(20);
        testeRequisiçãoAproveitamento.setDataRequisicao(dataRequisicao);
    }

    @Test
    public void testSetParecerServidor() {
        System.out.println("setParecerServidor");
        String parecerServidor = "Falta de documentos";
        testeRequisiçãoAproveitamento.setParecerServidor(parecerServidor);
    }

    @Test
    public void testSetParecerProfessor() {
        System.out.println("setParecerProfessor");
        String parecerProfessor = "Apovado";
        testeRequisiçãoAproveitamento.setParecerProfessor(parecerProfessor);
    }

    @Test
    public void testSetParecerCoordenador() {
        System.out.println("setParecerCoordenador");
        String parecerCoordenador = "Apto";
        testeRequisiçãoAproveitamento.setParecerCoordenador(parecerCoordenador);
    }

    @Test
    public void testSetDeferido() {
        System.out.println("setDeferido");
        String deferido = "Sim";
        testeRequisiçãoAproveitamento.setDeferido(deferido);
    }

    @Test
    public void testSetResponsavelPelaRequisicao() {
        System.out.println("setResponsavelPelaRequisicao");
        String responsavelPelaRequisicao = "Ensino";
        testeRequisiçãoAproveitamento.setResponsavelPelaRequisicao(responsavelPelaRequisicao);
    }

    @Test
    public void testSetDisciplinaSolicitada() {
        System.out.println("setDisciplinaSolicitada");
        Disciplina disciplinaSolicitada = new Disciplina();
        disciplinaSolicitada.setNome("Banco de Dados");
        testeRequisiçãoAproveitamento.setDisciplinaSolicitada(disciplinaSolicitada);
    }

    @Test
    public void testSetUsuario() {
        System.out.println("setUsuario");
        Usuario usuario = new Usuario();
        usuario.setUserName("Jader");
        testeRequisiçãoAproveitamento.setUsuario(usuario);
    }

    @Test
    public void testSetAnexos() {
        System.out.println("setAnexos");
        List<Anexo> anexos = null;
        testeRequisiçãoAproveitamento.setAnexos(anexos);
    }

    @Test
    public void testSetProfessor() {
        System.out.println("setProfessor");
        Usuario professor = new Usuario();
        professor.setUserName("Alexandro");
        testeRequisiçãoAproveitamento.setProfessor(professor);
    }
    

}
