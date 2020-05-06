package br.edu.ifrs.restinga.requisicoes.modelo.dao;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Curso;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Disciplina;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoDao extends PaginacaoRepository<Curso, Long> {

    public void save(ResponseEntity<Curso> curso);
    public Curso findByNome(String nome);

    @Query(value = "SELECT d FROM Curso c join c.disciplinas d WHERE c.id=?1 ORDER BY d.nome")
    public Page<Disciplina> findAll(Long id,Pageable p);
}
