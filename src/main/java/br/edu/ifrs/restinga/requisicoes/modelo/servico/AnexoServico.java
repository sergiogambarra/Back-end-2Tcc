package br.edu.ifrs.restinga.requisicoes.modelo.servico;

import br.edu.ifrs.restinga.requisicoes.modelo.dao.AnexoDao;
import br.edu.ifrs.restinga.requisicoes.modelo.dao.PaginacaoRepository;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Anexo;
import br.edu.ifrs.restinga.requisicoes.modelo.rn.AnexoRN;
import br.edu.ifrs.restinga.requisicoes.modelo.rn.RegraNenocio;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class AnexoServico extends ServicoCRUD<Anexo>{

    @Autowired
    private  AnexoDao dao;
    @Autowired
    private AnexoRN rn;

    @Override
        public PaginacaoRepository<Anexo, Long> getDAO() {
        return  dao;
    }

    @Override
    public RegraNenocio<Anexo> rn() {
        return rn;
    }
}
