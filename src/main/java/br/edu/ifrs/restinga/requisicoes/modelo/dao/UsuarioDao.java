package br.edu.ifrs.restinga.requisicoes.modelo.dao;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends PaginacaoRepository<Usuario, Long>{
    public Usuario findByUserName(String nome);
}
