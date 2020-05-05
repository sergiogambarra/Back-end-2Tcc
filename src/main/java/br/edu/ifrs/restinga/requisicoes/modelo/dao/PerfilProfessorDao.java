package br.edu.ifrs.restinga.requisicoes.modelo.dao;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.PerfilProfessor;
import org.springframework.stereotype.Repository;


@Repository
public interface PerfilProfessorDao extends PaginacaoRepository<PerfilProfessor, Long>{
}
