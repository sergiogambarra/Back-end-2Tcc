/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.requisicoes.modelo.dao;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Requisicao;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.RequisicaoAproveitamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jader
 */


@NoArgsConstructor
@AllArgsConstructor
@Repository
public class FilterDao {
    @Autowired
    private EntityManager manager;
    
    public List<Requisicao> filtro (){
        String sql = "SELECT r.id FROM RequisicaoAproveitamento as r";
        Query query = manager.createNativeQuery(sql, RequisicaoAproveitamento.class);
   
                
                
        return query.getResultList();
    }
}
