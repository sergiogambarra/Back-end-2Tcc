package br.edu.ifrs.restinga.requisicoes.modelo.dao;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.RequisicaoCertificacao;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface RequisicaoCertificacaoDao extends PaginacaoRepository<RequisicaoCertificacao, Long>{
    
 @Query(value = "SELECT r FROM RequisicaoCertificacao r ORDER BY r.id DESC")
    public List<RequisicaoCertificacao> findAllRequisicaoCertificacao();
}
