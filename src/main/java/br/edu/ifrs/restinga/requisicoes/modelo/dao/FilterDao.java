/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.requisicoes.modelo.dao;

import br.edu.ifrs.restinga.requisicoes.modelo.dto.FiltroDto;
import br.edu.ifrs.restinga.requisicoes.modelo.dto.RequisicaoDto;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    public List<RequisicaoDto> filtro(FiltroDto filtro) {

        StringBuilder sqlBase = new StringBuilder("Select r.id, p.nome, a.matricula, r.data_requisicao, d.nome as Disciplina, r.deferido from requisicao as r ");
        sqlBase.append(" INNER JOIN disciplinas as d on (r.disciplina_solicitada_id=d.id) INNER JOIN cursos_disciplinas as cd on (cd.disciplinas_id=d.id)");
        sqlBase.append(" INNER JOIN cursos as c on (c.id=cd.curso_id) INNER JOIN usuarios as u on (r.usuario_id=u.id)");
        sqlBase.append(" INNER JOIN ").append(filtro.getTipoRequisicao()).append(" as rt on r.id=rt.id ").append(" INNER JOIN perfis as p on (u.perfil_id=p.id)");
        sqlBase.append(" INNER JOIN alunos as a on (p.id=a.id) WHERE r.id=rt.id");

         if (filtro.getStatusRequisicao() != null) {
            sqlBase.append(" AND r.deferido='").append(filtro.getStatusRequisicao()).append("'");
        }
        if (filtro.getIdCurso() != null) {
            sqlBase.append(" AND c.id=").append(filtro.getIdCurso());
        }
        if (filtro.getIdDisciplina() != null) {
            sqlBase.append(" AND d.id=").append(filtro.getIdDisciplina());
        }
        if (filtro.getDataInicio() != null && filtro.getDataFinal() != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            sqlBase.append(" AND r.data_requisicao  between '").append(formatter.format(filtro.getDataInicio())).append("' and '").append(formatter.format(filtro.getDataFinal())).append("';");
        }
        
        System.out.println(filtro.getStatusRequisicao());
        Query query = manager.createNativeQuery(sqlBase.toString());
        List<Object[]> lista = query.getResultList();
        ArrayList<RequisicaoDto> result = new ArrayList<>();
        lista.forEach( objects  -> result.add(new RequisicaoDto(objects)) );
        return result;
    }
}
