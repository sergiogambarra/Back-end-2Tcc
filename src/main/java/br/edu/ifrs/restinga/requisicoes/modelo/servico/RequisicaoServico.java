/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.requisicoes.modelo.servico;

import br.edu.ifrs.restinga.requisicoes.modelo.dao.AnexoDao;
import br.edu.ifrs.restinga.requisicoes.modelo.dao.FilterDao;
import br.edu.ifrs.restinga.requisicoes.modelo.dao.PaginacaoRepository;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RequisicaoServico extends ServicoCRUD<Requisicao> {

    @Autowired
    RequisicaoDao requisicaoDao;
    
    @Autowired
    FilterDao filterDao;

    @Autowired
    RequisicaoAproveitamentoDao daoAproveitamento;

    @Autowired
    RequisicaoCertificacaoDao daoCertificacaoDao;

    @Autowired
    RequisicaoRN requisicaoRN;

    @Autowired
    UsuarioServico servicoUsuario;

    @Override
    public PaginacaoRepository<Requisicao, Long> getDAO() {
        return requisicaoDao;
    }
    @Autowired
    AnexoDao daoAnexo;

    @Override
    public RegraNenocio<Requisicao> rn() {
        return requisicaoRN;
    }

    @Override
    public Requisicao cadastrar(Requisicao entidade) {
        entidade.setDataRequisicao(new Date());
        entidade.setDeferido("EM ANÁLISE");
        requisicaoRN.validar(entidade);
        return requisicaoDao.save(entidade);
    }

    public Page<RequisicaoAproveitamento> listarAproveitamento(Pageable page) {
        return daoAproveitamento.findAllRequisicaoAproveitamentos(page);
    }

    public Page<RequisicaoCertificacao> listarCertificacao(Pageable page) {
        return daoCertificacaoDao.findAllRequisicaoCertificacao(page);
    }

    public List<Requisicao> listarCertificacaoSolicitante(Long id) {
        Usuario user = servicoUsuario.recuperar(id);
        Iterable<Requisicao> requisicoes = requisicaoDao.findAll();
        ArrayList<Requisicao> retorno = new ArrayList<>();
        requisicoes.forEach((t) -> {
            if (t.getUsuario() != null && user.getId() == t.getUsuario().getId()) {
                retorno.add(t);
            }
        });
        return retorno;
    }

    @Override
    public Requisicao atualizar(Requisicao entidade) {
        requisicaoRN.validaParecer(entidade);
        if (entidade instanceof RequisicaoCertificacao) {
            RequisicaoCertificacao certAntiga = daoCertificacaoDao.findById(entidade.getId()).get();
            certAntiga.setDeferido(entidade.getDeferido());
            certAntiga.setResponsavelPelaRequisicao(entidade.getResponsavelPelaRequisicao());
            certAntiga.setParecerCoordenador(entidade.getParecerCoordenador());
            certAntiga.setParecerProfessor(entidade.getParecerProfessor());
            certAntiga.setParecerServidor(entidade.getParecerServidor());
            if (((RequisicaoCertificacao) entidade).getProva() != null) {
            daoAnexo.save(((RequisicaoCertificacao) entidade).getProva());
            }
            certAntiga.setProva(((RequisicaoCertificacao) entidade).getProva());
            if (entidade.getProfessor() != null) {
                certAntiga.setProfessor(entidade.getProfessor());
            }
            return super.atualizar(certAntiga);
        } else if (entidade instanceof RequisicaoAproveitamento) {
            RequisicaoAproveitamento certAntiga = daoAproveitamento.findById(entidade.getId()).get();
            certAntiga.setDeferido(entidade.getDeferido());
            certAntiga.setResponsavelPelaRequisicao(entidade.getResponsavelPelaRequisicao());
            certAntiga.setParecerCoordenador(entidade.getParecerCoordenador());
            certAntiga.setParecerProfessor(entidade.getParecerProfessor());
            certAntiga.setParecerServidor(entidade.getParecerServidor());
            if (entidade.getProfessor() != null) {
                certAntiga.setProfessor(entidade.getProfessor());
            }
            return super.atualizar(certAntiga);
        }
        return null;
    }

    public Page<Requisicao> listarPorProfessor(Long id, String tipo, Pageable p) {
        if (tipo.equals("aproveitamento")) {
            return requisicaoDao.listarRequisicaoAproveitamento(id, p);
        }
        return requisicaoDao.listarRequisicaoCertificacao(id, p);
    }

    public Page<Requisicao> listarData(Date i, Date f, Pageable p) {
        return requisicaoDao.findByDataRequisicaoBetween(i, f, p);
    }
    public List<Requisicao> listarDataRelatorio(Date i, Date f) {
        return requisicaoDao.findByDataRequisicaoBetween(i, f);
    }

    public Page<Requisicao> listarRequisicaoAluno(Long id, Pageable p) {
        return requisicaoDao.listarRequisicoesAlunos(id, p);
    }

    public Page<Requisicao> listarStatus(String status, Pageable p) {
        return requisicaoDao.findByDeferido(status, p);
    }

    public Page<RequisicaoAproveitamento> listarRequisicaoAlunoAproveitamento(Long id, Pageable p) {
        return daoAproveitamento.requisicaoAlunoAproveitamento(id, p);
    }

    public Page<RequisicaoCertificacao> listarRequisicaoAlunoCertificacao(Long id, Pageable p) {
        return daoCertificacaoDao.requisicaoAlunoCertificacao(id, p);
    }

    public Page<Requisicao> listarRequisicaoCurso(Long id, Pageable p) {
        return requisicaoDao.findByDisciplinaSolicitada(id, p);
    }

    public List<RequisicaoAproveitamento> testeAll(String teste) {
        return filterDao.filtro(teste);
    }
}
