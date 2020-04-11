package br.edu.ifrs.restinga.requisicoes.modelo.dao;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Curso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;


@Repository
public interface CursoDao extends CrudRepository<Curso, Long>{

    public void save(ResponseEntity<Curso> curso);
}
