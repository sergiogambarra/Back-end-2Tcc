package br.edu.ifrs.restinga.requisicoes.controle;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Disciplina;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.DisciplinaServico;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.ServicoCRUD;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@Api("Api : Disciplinas")
@RequestMapping("/api/disciplinas/")
public class DisciplinaControle extends CRUDControle<Disciplina>{

    @Autowired
    private DisciplinaServico servico;

    @Override
    public ServicoCRUD<Disciplina> getService() {
        return servico;
    }
    
}
