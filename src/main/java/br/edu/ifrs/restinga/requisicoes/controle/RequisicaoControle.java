package br.edu.ifrs.restinga.requisicoes.controle;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Requisicao;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.RequisicaoAproveitamento;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.RequisicaoCertificacao;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.RequisicaoServico;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.ServicoCRUD;
import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@Api("Api : Requisições")
@RequestMapping("/api/requisicoes/")
public class RequisicaoControle extends CRUDControle<Requisicao>{

    
    @Autowired
    RequisicaoServico requisicaoServico;
    
    @Override
    public ServicoCRUD<Requisicao> getService() {
        return requisicaoServico;
    }
    @GetMapping("aproveitamentos/")
    public ResponseEntity<Iterable<RequisicaoAproveitamento>> listarAproveitamento(){
        return ResponseEntity.ok().body(requisicaoServico.listarAproveitamento());
    }
    @GetMapping("certificacoes/")
    public ResponseEntity<Iterable<RequisicaoCertificacao>> listarCertificao(){
        return ResponseEntity.ok().body(requisicaoServico.listarCertificacao());
    }
    
    @GetMapping("solicitante/{id}")
     public ResponseEntity<List<Requisicao>> listarCertificaoUsuario(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(requisicaoServico.listarCertificacaoSolicitante(id));
    }
     
     
}
