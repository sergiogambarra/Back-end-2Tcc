package br.edu.ifrs.restinga.requisicoes.modelo.dao;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends PaginacaoRepository<Usuario, Long>{
    
    public Usuario findByUserName(String nome);
    
    public Usuario findByEmail(String email);
    
    @Query("SELECT u FROM Usuario u WHERE u.permissao=?1 ORDER BY u.perfil.nome")
    public Page<Usuario> listarUsuarios(String tipo,Pageable p);
   
    @Query("SELECT u FROM Usuario u join u.perfil p WHERE u.permissao='ALUNO' AND p.matricula=?1")
    public Usuario findByPerfilMatricula(int matricula);
    
    @Query("SELECT u FROM Usuario u join u.perfil p WHERE p.siape=?1")
    public Usuario findByPerfilSiape(Integer siape);
    
    @Query("SELECT u FROM Usuario u join u.perfil p WHERE p.nome=?1 ")
    public List<Usuario> findByNome(String nome);
}
