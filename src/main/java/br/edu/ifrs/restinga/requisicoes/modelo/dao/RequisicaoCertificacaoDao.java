package br.edu.ifrs.restinga.requisicoes.modelo.dao;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.RequisicaoCertificacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisicaoCertificacaoDao extends PaginacaoRepository<RequisicaoCertificacao, Long> {

    @Query(value = "SELECT r FROM RequisicaoCertificacao r ORDER BY r.id DESC")
    public Page<RequisicaoCertificacao> findAllRequisicaoCertificacao(Pageable page);

    @Query("SELECT r FROM RequisicaoCertificacao r join r.usuario u WHERE u.permissao='ALUNO' AND u.id=?1  ORDER BY r.id DESC")
    public Page<RequisicaoCertificacao> requisicaoAlunoCertificacao(Long id, Pageable p);

    @Query("SELECT r FROM RequisicaoCertificacao r join r.usuario u WHERE u.permissao='ALUNO' AND u.id=?1  ORDER BY r.id DESC")
    public Page<RequisicaoCertificacao> requisicaoDoCoordenador(Long id, Pageable p);

    @Query(value = "Select r.id,r.data_requisicao,r.deferido,r.disciplina_solicitada_id,r.parecer_coordenador, r.parecer_professor,r.parecer_servidor, r.professor_id, r.responsavel_pela_requisicao, r.usuario_id, rt.formacao_atividade_anterior, rt.prova_id from requisicao as r INNER JOIN disciplinas as d on (r.disciplina_solicitada_id=d.id) "
            + "INNER JOIN cursos_disciplinas as cd on (cd.disciplinas_id=d.id) INNER JOIN cursos as c on (c.id=cd.curso_id) "
            + "INNER JOIN requisicoes_certificacao as rt INNER JOIN usuarios as u on (r.usuario_id=u.id) Where r.id=rt.id AND c.usuario_id=?1  ORDER BY r.id DESC", nativeQuery = true)
    public Page<RequisicaoCertificacao> requisicaocertificacaoCoordenador(Long id, Pageable p);

}
