package br.edu.ifrs.restinga.requisicoes.modelo.dao;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.PerfilServidor;
import org.springframework.stereotype.Repository;


@Repository
public interface PerfilServidorDao extends PaginacaoRepository<PerfilServidor, Long>{
}
