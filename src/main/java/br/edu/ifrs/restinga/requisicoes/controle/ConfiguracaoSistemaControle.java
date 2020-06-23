/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.requisicoes.controle;

import br.edu.ifrs.restinga.requisicoes.modelo.dao.ConfiguracaoSistemaDao;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.ConfiguracaoSistema;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.ConfiguracaoServico;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.ServicoCRUD;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@Api("Api : ConfiguracaoSistema")
@RequestMapping("/api/configuracao/")
public class ConfiguracaoSistemaControle extends CRUDControle<ConfiguracaoSistema>{
    
    @Autowired
    private ConfiguracaoServico servico;
    
     @Autowired
    private ConfiguracaoSistemaDao dao;

    @Override
    public ServicoCRUD<ConfiguracaoSistema> getService() {
        return servico;
    }

    @GetMapping("valida/")
    public Boolean verificaDataSistema(){
        return servico.verificaDataSistema();
    }
}
