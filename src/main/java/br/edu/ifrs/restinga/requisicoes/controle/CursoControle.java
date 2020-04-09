package br.edu.ifrs.restinga.requisicoes.controle;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Curso;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Disciplina;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.CursoServico;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.ServicoCRUD;
import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@Api("Api : Cursos")
@RequestMapping("/api/cursos/")
public class CursoControle extends CRUDControle<Curso>{

    @Autowired
    private CursoServico servico;

    @Override
    public ServicoCRUD<Curso> getService() {
       return servico;
    }
      
    @PostMapping("{id}/disciplinas/")
    public ResponseEntity<List<Disciplina>> cadastrarDisciplinaNoCurso(@PathVariable Long id, @RequestBody Disciplina d){
        return new ResponseEntity(servico.cadastrarDisciplinaNoCurso(id, d).getBody(),HttpStatus.CREATED);
    }
}
