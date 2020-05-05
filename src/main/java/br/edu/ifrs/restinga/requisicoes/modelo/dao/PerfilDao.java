package br.edu.ifrs.restinga.requisicoes.modelo.dao;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Perfil;
import org.springframework.stereotype.Repository;


@Repository
public interface PerfilDao extends PaginacaoRepository<Perfil, Long>{
}
