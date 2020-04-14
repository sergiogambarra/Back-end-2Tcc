/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.requisicoes.modelo.servico;

import br.edu.ifrs.restinga.requisicoes.modelo.dao.RequisicaoAproveitamentoDao;
import br.edu.ifrs.restinga.requisicoes.modelo.dao.RequisicaoCertificacaoDao;
import br.edu.ifrs.restinga.requisicoes.modelo.dao.RequisicaoDao;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Requisicao;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.RequisicaoAproveitamento;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.RequisicaoCertificacao;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
import br.edu.ifrs.restinga.requisicoes.modelo.rn.RegraNenocio;
import br.edu.ifrs.restinga.requisicoes.modelo.rn.RequisicaoRN;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    RequisicaoAproveitamentoDao daoAproveitamento;
    
    @Autowired
    RequisicaoCertificacaoDao daoCertificacaoDao;

    @Autowired
    RequisicaoRN requisicaoRN;
    
    @Autowired
    UsuarioServico servicoUsuario;
    

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

    public ResponseEntity<List<Requisicao>> listarAproveitamento(){
        return new ResponseEntity(daoAproveitamento.findAll(),HttpStatus.OK);
    }
    
    public ResponseEntity<List<Requisicao>> listarCertificacao(){
        return new ResponseEntity(daoCertificacaoDao.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<List<Requisicao>> listarCertificacaoSolicitante(Long id) {
        Usuario user = servicoUsuario.recuperar(id).getBody();
        Iterable<Requisicao> requisicoes = requisicaoDao.findAll();
        ArrayList<Requisicao> retorno = new ArrayList<>();
        requisicoes.forEach((t) -> {
            if(t.getUsuario() != null && user.getId() == t.getUsuario().getId()){
                retorno.add(t);
            }
        });
        return new ResponseEntity(retorno,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Requisicao> atualizar(Requisicao entidade) {
        if(entidade instanceof RequisicaoCertificacao){
            RequisicaoCertificacao certAntiga = daoCertificacaoDao.findById(entidade.getId()).get();
            certAntiga.setDeferido(entidade.getDeferido());
            certAntiga.setParecer(entidade.getParecer());
            return super.atualizar(certAntiga); 
        }else if (entidade instanceof RequisicaoAproveitamento){
            RequisicaoAproveitamento certAntiga = daoAproveitamento.findById(entidade.getId()).get();
            certAntiga.setDeferido(entidade.getDeferido());
            certAntiga.setParecer(entidade.getParecer());
            return super.atualizar(certAntiga); 
        }
        return null;
    }   
}
