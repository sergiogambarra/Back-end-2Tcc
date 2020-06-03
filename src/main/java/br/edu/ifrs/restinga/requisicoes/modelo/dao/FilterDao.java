/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.requisicoes.modelo.dao;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.RequisicaoAproveitamento;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jader
 */


@NoArgsConstructor
@AllArgsConstructor
@Repository
public class FilterDao {
        
    @PersistenceContext
    private EntityManager manager;
    
    public List<RequisicaoAproveitamento> filtro (String teste){
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<RequisicaoAproveitamento> criteria = builder.createQuery(RequisicaoAproveitamento.class);
        Root<RequisicaoAproveitamento> root = criteria.from(RequisicaoAproveitamento.class);
        From<?, ?> disciplina = root.join("disciplinaSolicitada",JoinType.INNER);
        criteria.where(this.condicoes());
        return manager.createQuery(criteria).getResultStream().collect(Collectors.toList());
    }
    
    private Predicate[] condicoes (){
        List<Predicate> predicates = new ArrayList<>();
        
        return predicates.toArray(new Predicate[predicates.size()]);
    }
    
    
    
    
    
}
