package br.edu.ifrs.restinga.requisicoes.modelo.dao;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.RequisicaoCertificacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface RequisicaoCertificacaoDao extends PaginacaoRepository<RequisicaoCertificacao, Long>{
    
 @Query(value = "SELECT r FROM RequisicaoCertificacao r ORDER BY r.id DESC")
    public Page<RequisicaoCertificacao> findAllRequisicaoCertificacao(Pageable page);
//    public Page<RequisicaoCertificacao> findAllRequisicaoCertificacao(Pageable p);
}
