
package br.edu.ifrs.restinga.requisicoes.modelo.dao;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Requisicao;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RequisicaoDao extends CrudRepository<Requisicao, Long>{
    public List<Requisicao> findByUsuario(Usuario u);
    
   @Query("SELECT r FROM RequisicaoAproveitamento r WHERE r.professor.id = ?1")
   public List<Requisicao> listarRequisicaoAproveitamento (Long id);
   
   @Query("SELECT r FROM RequisicaoCertificacao r WHERE r.professor.id = ?1")
   public List<Requisicao> listarRequisicaoCertificacao (Long id);
    
}