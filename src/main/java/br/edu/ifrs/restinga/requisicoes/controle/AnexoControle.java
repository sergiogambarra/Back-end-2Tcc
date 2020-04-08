package br.edu.ifrs.restinga.requisicoes.controle;


import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Anexo;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.AnexoServico;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.ServicoCRUD;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@Api("Api : Anexos")
@RequestMapping("/api/anexos/")
public class AnexoControle extends CRUDControle<Anexo>{

    @Autowired
    private AnexoServico servico;
    
    @Override
    public ServicoCRUD<Anexo> getService() {
        return servico;
    }
    
}
