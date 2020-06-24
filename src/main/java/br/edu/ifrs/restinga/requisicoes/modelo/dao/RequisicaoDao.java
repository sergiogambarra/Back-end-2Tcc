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

    @Query("SELECT r FROM Requisicao r WHERE data_requisicao BETWEEN ?1 AND ?2  ORDER BY r.usuario.perfil.nome")
    public List<Requisicao> findByDataRequisicaoBetween(Date i, Date f);

    @Query("SELECT r FROM Requisicao r WHERE r.deferido=?1 ORDER BY r.id DESC")
    public Page<Requisicao> findByDeferido(String status, Pageable p);

    @Query("SELECT r FROM Requisicao r WHERE r.disciplinaSolicitada.id=?1  ORDER BY r.id DESC")
    public Page<Requisicao> findByDisciplinaSolicitada(Long id, Pageable p);

    @Query(value = "Select r.id, r.data_requisicao,d.nome,r.deferido,p.nome as Aluno, (select nome from perfis where id=r.professor_id) as Professor from requisicao as r"
            + " INNER JOIN disciplinas as d on (r.disciplina_solicitada_id=d.id)"
            + " INNER JOIN cursos_disciplinas as cd on (cd.disciplinas_id=d.id)"
            + " INNER JOIN requisicoes_aproveitamento as rt on (r.id = rt.id )"
            + " INNER JOIN usuarios as u on (u.id = r.usuario_id)"
            + " INNER JOIN perfis as p on (p.id=u.id)"
            + " INNER JOIN cursos as c on (cd.curso_id=c.id) WHERE c.usuario_id=3",nativeQuery = true)
    public Page<Requisicao>teste( Pageable p);
    
    @Query(value = "Select r.id, r.data_requisicao,d.nome,r.deferido,p.nome as Aluno, (select nome from perfis where id=r.professor_id) as Professor from requisicao as r INNER JOIN disciplinas as d on (r.disciplina_solicitada_id=d.id)"
            + " INNER JOIN cursos_disciplinas as cd on (cd.disciplinas_id=d.id)"
            + " INNER JOIN requisicoes_certificacao as rt on (r.id = rt.id )"
            + " INNER JOIN usuarios as u on (u.id = r.usuario_id)"
            + " INNER JOIN perfis as p on (p.id=u.id)"
            + " INNER JOIN cursos as c on (cd.curso_id=c.id) WHERE c.usuario_id=4",nativeQuery = true)
    public Page<Requisicao>teste2( Pageable p);

}
