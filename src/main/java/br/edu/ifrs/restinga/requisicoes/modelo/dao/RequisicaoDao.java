package br.edu.ifrs.restinga.requisicoes.modelo.dao;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Requisicao;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.RequisicaoAproveitamento;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.RequisicaoCertificacao;
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
//   
//   public List<Requisicao> findByDataRequisicaoBefore(Date data);
//   
//   public List<Requisicao> findByDataRequisicaoBetween(Date data);

}
//data inicial e data final – 2 campos de calendários 
//curso – select com a lista de cursos
//aluno – select com a lista de alunos
//status da requisição – select com as opções Não iniciada, Em andamento, e Finalizada
