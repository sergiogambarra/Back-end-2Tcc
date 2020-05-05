package br.edu.ifrs.restinga.requisicoes.modelo.dao;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Anexo;
import org.springframework.stereotype.Repository;


@Repository
public interface AnexoDao extends PaginacaoRepository<Anexo, Long>{
}
