package br.edu.ifrs.restinga.requisicoes.modelo.dao;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Disciplina;
import org.springframework.stereotype.Repository;


@Repository
public interface DisciplinaDao extends PaginacaoRepository<Disciplina, Long>{
    
     
}
