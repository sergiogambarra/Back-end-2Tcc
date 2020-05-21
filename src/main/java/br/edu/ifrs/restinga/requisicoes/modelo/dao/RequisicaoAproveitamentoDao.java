package br.edu.ifrs.restinga.requisicoes.modelo.dao;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.RequisicaoAproveitamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface RequisicaoAproveitamentoDao extends PaginacaoRepository<RequisicaoAproveitamento, Long>{
    
    @Query(value = "SELECT r FROM RequisicaoAproveitamento r ORDER BY r.id DESC")
    public Page<RequisicaoAproveitamento> findAllRequisicaoAproveitamentos(Pageable page);
    
    @Query("SELECT r FROM RequisicaoAproveitamento r join r.usuario u WHERE u.permissao='ALUNO' AND u.id=?1  ORDER BY r.id DESC")
    public Page<RequisicaoAproveitamento> requisicaoAlunoAproveitamento(Long id, Pageable p);
}
