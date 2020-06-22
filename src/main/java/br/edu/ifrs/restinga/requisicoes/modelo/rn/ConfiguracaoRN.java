/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.requisicoes.modelo.rn;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.ConfiguracaoSistema;
import org.springframework.stereotype.Component;

/**
 *
 * @author jader
 */
    @Component
public class ConfiguracaoRN implements RegraNenocio<ConfiguracaoSistema> {

    @Override
    public void validar(ConfiguracaoSistema entidade) {
        
    }
}
