package br.edu.ifrs.restinga.requisicoes.controle;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Requisicao;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.RequisicaoAproveitamento;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.RequisicaoCertificacao;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.RequisicaoServico;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.ServicoCRUD;
import io.swagger.annotations.Api;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@Api("Api : Requisições")
@RequestMapping("/api/requisicoes/")
public class RequisicaoControle extends CRUDControle<Requisicao> {

    @Autowired
    RequisicaoServico requisicaoServico;

    @Override
    public ServicoCRUD<Requisicao> getService() {
        return requisicaoServico;
    }

    @GetMapping("aproveitamentos")
    public ResponseEntity<Page<RequisicaoAproveitamento>> listarAproveitamento(Pageable page) {
        return ResponseEntity.ok().body(requisicaoServico.listarAproveitamento(page));
    }

    @GetMapping("certificacoes")
    public ResponseEntity<Page<RequisicaoCertificacao>> listarCertificao(Pageable page) {
        return ResponseEntity.ok().body(requisicaoServico.listarCertificacao(page));
    }

    @GetMapping("solicitante/{id}")
    public ResponseEntity<List<Requisicao>> listarCertificaoUsuario(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(requisicaoServico.listarCertificacaoSolicitante(id));
    }

    @GetMapping("professor/{id}")
    public ResponseEntity<Page<Requisicao>> listarRequisicoesProfessor(@PathVariable("id") Long id, @RequestParam(value = "tipo") String tipo, Pageable page) {
        return ResponseEntity.ok().body(requisicaoServico.listarPorProfessor(id, tipo,page));
    }

    @GetMapping("data/{dataInicial}/{dataFinal}/")
    public ResponseEntity<Page<Requisicao>> listarData(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy")  Date dataInicial,@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy")  Date dataFinal ,Pageable page) {
        return ResponseEntity.ok(requisicaoServico.listarData(dataInicial, dataFinal, page));
    }
    
    @GetMapping("alunos/{id}")
    public ResponseEntity<Page<Requisicao>> listarTodas(@PathVariable Long id, Pageable page) {
        return ResponseEntity.ok(requisicaoServico.listarRequisicaoAluno(id,page));
    }
    @GetMapping("aproveitamento/alunos/{id}")
    public ResponseEntity<Page<RequisicaoAproveitamento>> listarRequisicoesAproveitamentoAluno(@PathVariable Long id, Pageable page) {
        return ResponseEntity.ok(requisicaoServico.listarRequisicaoAlunoAproveitamento(id, page));
    }
    @GetMapping("certificacao/alunos/{id}")
    public ResponseEntity<Page<RequisicaoCertificacao>> listarRequisicoesCertificacaoAluno(@PathVariable Long id, Pageable page) {
        return ResponseEntity.ok(requisicaoServico.listarRequisicaoAlunoCertificacao(id, page));
    }
}
