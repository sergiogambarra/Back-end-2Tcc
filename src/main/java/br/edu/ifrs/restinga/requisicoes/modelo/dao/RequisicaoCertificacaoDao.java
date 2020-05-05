package br.edu.ifrs.restinga.requisicoes.modelo.dao;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.RequisicaoCertificacao;
import org.springframework.stereotype.Repository;


@Repository
public interface RequisicaoCertificacaoDao extends PaginacaoRepository<RequisicaoCertificacao, Long>{
}
