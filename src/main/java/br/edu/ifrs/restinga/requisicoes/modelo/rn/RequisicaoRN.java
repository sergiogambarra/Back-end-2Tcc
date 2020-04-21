/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.requisicoes.modelo.rn;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Requisicao;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.RequisicaoAproveitamento;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.RequisicaoCertificacao;
import org.springframework.stereotype.Component;

@Component
public class RequisicaoRN implements RegraNenocio<Requisicao>{

    @Override
       public void validar(Requisicao entidade) {
        if(entidade instanceof RequisicaoAproveitamento){
            this.validaAproveitamento((RequisicaoAproveitamento) entidade);
        }else{
            this.validaCertificacao((RequisicaoCertificacao) entidade);
        }
    }

       
    private void validaAproveitamento(RequisicaoAproveitamento req) {
//        validaCampo(req.getTipo(), "tipo");
//        validaCampo(req.getDisciplinasCursadasAnterior(), "disciplina cursadas anteriormente");
//        validaCampo(req.getDeferido(), "deferido");
//        validaAnexos(req.getAnexos(), "anexos");
    }

    private void validaCertificacao(RequisicaoCertificacao req) {
    }
    

    
}
