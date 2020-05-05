package br.edu.ifrs.restinga.requisicoes.modelo.dao;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.RequisicaoAproveitamento;
import org.springframework.stereotype.Repository;


@Repository
public interface RequisicaoAproveitamentoDao extends PaginacaoRepository<RequisicaoAproveitamento, Long>{
}
