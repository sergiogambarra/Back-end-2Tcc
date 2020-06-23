package br.edu.ifrs.restinga.requisicoes.modelo.servico;

import br.edu.ifrs.restinga.requisicoes.modelo.dao.ConfiguracaoSistemaDao;
import br.edu.ifrs.restinga.requisicoes.modelo.dao.PaginacaoRepository;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.ConfiguracaoSistema;
import br.edu.ifrs.restinga.requisicoes.modelo.rn.ConfiguracaoRN;
import br.edu.ifrs.restinga.requisicoes.modelo.rn.RegraNenocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ConfiguracaoServico extends ServicoCRUD<ConfiguracaoSistema>{

    @Autowired
    private  ConfiguracaoSistemaDao dao;
    
    @Autowired
    private ConfiguracaoRN rn;

    @Override
    public PaginacaoRepository<ConfiguracaoSistema, Long> getDAO() {
        return dao;
    }

    @Override
    public RegraNenocio<ConfiguracaoSistema> rn() {
       return rn;
    }
 
 
    public Boolean verificaDataSistema(){
        return "1".equals(dao.validaSistema());
    }

    
}
