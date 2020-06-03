package br.edu.ifrs.restinga.requisicoes.modelo.dao;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Requisicao;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisicaoDao extends PaginacaoRepository<Requisicao, Long> {

    public List<Requisicao> findByUsuario(Usuario u);

    @Query("SELECT r FROM RequisicaoAproveitamento r WHERE r.professor.id = ?1 ORDER BY r.id DESC")
    public Page<Requisicao> listarRequisicaoAproveitamento(Long id, Pageable p);

    @Query("SELECT r FROM RequisicaoCertificacao r WHERE r.professor.id = ?1 ORDER BY r.id DESC")
    public Page<Requisicao> listarRequisicaoCertificacao(Long id, Pageable p);

    @Query("SELECT r FROM Requisicao r join r.usuario u WHERE u.permissao='ALUNO' AND u.id=?1  ORDER BY r.id DESC")
    public Page<Requisicao> listarRequisicoesAlunos(Long id, Pageable p);

   public Page<Requisicao> findByDataRequisicaoBetween(Date i, Date f, Pageable p);
   
//   @Query("SELECT r FROM Requisicao r ORDER BY r.usuario.perfil.nome")
   public List<Requisicao> findByDataRequisicaoBetween(Date i, Date f);
   
    @Query("SELECT r FROM Requisicao r WHERE r.deferido=?1 ORDER BY r.id DESC")
   public Page<Requisicao> findByDeferido(String status , Pageable p);
   
    @Query("SELECT r FROM Requisicao r WHERE r.disciplinaSolicitada.id=?1  ORDER BY r.id DESC")
   public Page<Requisicao> findByDisciplinaSolicitada(Long id , Pageable p);

}
//curso – select com a lista de cursos
//status da requisição – select com as opções Não iniciada, Em andamento, e Finalizada
