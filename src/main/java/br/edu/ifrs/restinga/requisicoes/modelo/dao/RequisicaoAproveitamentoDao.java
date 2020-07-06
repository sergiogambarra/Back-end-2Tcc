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
    
    @Query(value = "Select r.id from requisicao as r INNER JOIN disciplinas as d on (r.disciplina_solicitada_id=d.id) " +
                    "INNER JOIN cursos_disciplinas as cd on (cd.disciplinas_id=d.id) " +
                    "INNER JOIN cursos as c on (c.id=cd.curso_id) " +
                    "INNER JOIN requisicoes_aproveitamento as rt " +
                    "INNER JOIN usuarios as u on (r.usuario_id=u.id) Where r.id=rt.id AND c.usuario_id = ?1;", nativeQuery = true)
    public Page<RequisicaoAproveitamento> requisicaoAproveitamentoCoordenador(Long id, Pageable p);
    
    
}
