package br.edu.ifrs.restinga.requisicoes.controle;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Requisicao;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.RequisicaoServico;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.ServicoCRUD;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    
    
    
}
