package br.edu.ifrs.restinga.requisicoes.controle;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Anexo;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.AnexoServico;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.ImportacaoCsvServico;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.ServicoCRUD;
import io.swagger.annotations.Api;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@Api("Api : Anexos")
@RequestMapping("/api/anexos/")
public class AnexoControle extends CRUDControle<Anexo> {

    @Autowired
    private AnexoServico servico;

    @Autowired
    private ImportacaoCsvServico importacaoCsvServico;

    @Override
    public ServicoCRUD<Anexo> getService() {
        return servico;
    }

    @RequestMapping(value = "/cursos", method = RequestMethod.POST)
    public void importarCursos(@RequestParam("umArquivo") MultipartFile arquivo) throws IOException {
        importacaoCsvServico.importacaoCsvCurso(arquivo);
    }
    @RequestMapping(value = "/disciplinas", method = RequestMethod.POST)
    public void importarDisciplinas(@RequestParam("umArquivo") MultipartFile arquivo) throws IOException {
        importacaoCsvServico.ImportarDisciplinas(arquivo);
    }
    @RequestMapping(value = "/usuarios", method = RequestMethod.POST)
    public void importarUsuarios(@RequestParam("umArquivo") MultipartFile arquivo) throws IOException {
        importacaoCsvServico.ImportarUsuarios(arquivo);
    }
    
    
//      @PostMapping(value = "/usuarios", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public void importarUsuarios(@RequestParam("umArquivo") MultipartFile arquivo) throws IOException {
//        System.out.println(arquivo.getOriginalFilename());
//        importacaoCsvServico.ImportarUsuarios(arquivo);
//    }
}
