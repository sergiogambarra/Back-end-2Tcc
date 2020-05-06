package br.edu.ifrs.restinga.requisicoes.modelo.dao;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends PaginacaoRepository<Usuario, Long>{
    public Usuario findByUserName(String nome);
    
    @Query("SELECT u FROM Usuario u WHERE u.permissao=?1 ORDER BY u.perfil.nome")
    public Page<Usuario> listarAlunos(String tipo,Pageable p);
    
}
