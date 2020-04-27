package br.edu.ifrs.restinga.requisicoes.modelo.servico;

import br.edu.ifrs.restinga.requisicoes.modelo.dao.DisciplinaDao;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Disciplina;
import br.edu.ifrs.restinga.requisicoes.modelo.rn.DisciplinaRN;
import br.edu.ifrs.restinga.requisicoes.modelo.rn.RegraNenocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public class DisciplinaServico extends ServicoCRUD<Disciplina>{

    @Autowired
    private  DisciplinaDao dao;
    @Autowired
    private DisciplinaRN rn;
    
    @Override
    public CrudRepository<Disciplina, Long> getDAO() {
        return  dao;
    }

    @Override
    public RegraNenocio<Disciplina> rn() {
        return rn;
    } 
    
    
}
