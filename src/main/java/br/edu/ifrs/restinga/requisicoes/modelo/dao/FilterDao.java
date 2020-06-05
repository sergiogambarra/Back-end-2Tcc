/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.requisicoes.modelo.dao;

import br.edu.ifrs.restinga.requisicoes.modelo.dto.FiltroDto;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Requisicao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;





@NoArgsConstructor
@AllArgsConstructor
@Repository
public class FilterDao {
    @Autowired
    private EntityManager manager;
    
    public List<Requisicao> filtro (FiltroDto filtro){
        StringBuilder sqlBase = new StringBuilder("SELECT r FROM Requisicao r");
//        if(filtro.getIdDisciplina() != null){
            sqlBase.append(" join r.disciplinaSolicitada d join d.curso c where c.id = 1");
//        }
        Query query = manager.createQuery(sqlBase.toString());
        return query.getResultList();
        
        }
}






 