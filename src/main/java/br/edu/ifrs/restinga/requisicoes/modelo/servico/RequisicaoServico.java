/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.requisicoes.modelo.servico;

import br.edu.ifrs.restinga.requisicoes.modelo.dao.RequisicaoDao;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Requisicao;
import br.edu.ifrs.restinga.requisicoes.modelo.rn.RegraNenocio;
import br.edu.ifrs.restinga.requisicoes.modelo.rn.RequisicaoRN;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RequisicaoServico extends ServicoCRUD<Requisicao> {

    @Autowired
    RequisicaoDao requisicaoDao;

    @Autowired
    RequisicaoRN requisicaoRN;

    @Override
    public CrudRepository<Requisicao, Long> getDAO() {
        return requisicaoDao;
    }

    @Override
    public RegraNenocio<Requisicao> rn() {
        return requisicaoRN;
    }

    @Override
    public ResponseEntity<Requisicao> cadastrar(Requisicao entidade) {
        entidade.setDataRequisicao(new Date());
        entidade.setDeferido("EM ANÁLISE");
        requisicaoRN.validar(entidade);
        Requisicao requi = requisicaoDao.save(entidade);
        return new ResponseEntity(requi, HttpStatus.CREATED);
    }

}
