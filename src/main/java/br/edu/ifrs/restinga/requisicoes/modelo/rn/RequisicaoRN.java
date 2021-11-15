/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.requisicoes.modelo.rn;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Anexo;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Requisicao;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.RequisicaoAproveitamento;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.RequisicaoCertificacao;
import br.edu.ifrs.restinga.requisicoes.modelo.exception.MensagemErroGenericaException;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class RequisicaoRN implements RegraNenocio<Requisicao> {

    private final List<String> extensoesValidas = Arrays.asList("pdf", "jpg", "png","jpeg");

    @Override
    public void validar(Requisicao entidade) {
        this.validaAnexos(entidade.getAnexos());
        if (entidade instanceof RequisicaoAproveitamento) {
            this.validaAproveitamento((RequisicaoAproveitamento) entidade);
        } else {
            this.validaCertificacao((RequisicaoCertificacao) entidade);
        }
    }

    private void validaAproveitamento(RequisicaoAproveitamento req) {
        if (req.getDisciplinasCursadasAnterior().length() > 100) {
            throw new MensagemErroGenericaException("Limite máximo de 45 caracteres para cadastro de disciplinas cursadas anteriormente.");
        }
    }

    private void validaCertificacao(RequisicaoCertificacao req) {
        if (req.getFormacaoAtividadeAnterior(). length() > 100) {
            throw new MensagemErroGenericaException("Limite máximo de 45 caracteres para cadastro de atividade exercida anteriormente.");
        }
    }

    private void validaAnexos(List<Anexo> anexos) {
        anexos.forEach((anexo) -> {
            if (!extensoesValidas.contains(anexo.getTipo())) {
                throw new MensagemErroGenericaException("arquivo não suportado !");
            }
        });
    }
    public void validaParecer(Requisicao entidade){
        if(entidade.getParecerServidor() == null || "".equals(entidade.getParecerServidor().trim())){
            throw new MensagemErroGenericaException("Campo parecer é obrigatório");
        }
    }
}
