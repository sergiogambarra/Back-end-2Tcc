package br.edu.ifrs.restinga.requisicoes.controle;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Curso;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Disciplina;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.CursoServico;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.ServicoCRUD;
import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@Api("Api : Cursos")
@RequestMapping("/api/cursos/")
public class CursoControle extends CRUDControle<Curso> {

    @Autowired
    private CursoServico servico;

    @Override
    public ServicoCRUD<Curso> getService() {
        return servico;
    }

    @GetMapping("{id}/disciplinas/")
    public ResponseEntity<List<Disciplina>> listarDSisciplinas(@PathVariable Long id) {
        return ResponseEntity.ok(servico.listarDisciplinas(id));
    }
    
    @GetMapping("{id}/disciplinas/paginacao")
    public ResponseEntity<Page<Disciplina>> listarDSisciplinas(@PathVariable Long id,Pageable p) {
        return ResponseEntity.ok(servico.listarPaginacao(id, p));
    }
    
    @GetMapping("{id}/disciplinas/{idDisciplina}")
    public ResponseEntity<List<Disciplina>> listarDSisciplinasPeloId(@PathVariable Long id,@PathVariable Long idDisciplina) {
        return new ResponseEntity(servico.listarDisciplinasPeloID(id, idDisciplina),HttpStatus.OK);
    }
    @GetMapping("coordenador/{id}")
    public ResponseEntity<Curso> listarNomeCursoPeloCoordenador(@PathVariable Long id) {
        return new ResponseEntity(servico.listarPeloCoordenador(id),HttpStatus.OK);
    }

    @PostMapping("{id}/disciplinas/")
    public ResponseEntity<List<Disciplina>> cadastrarDisciplinaNoCurso(@PathVariable Long id, @RequestBody Disciplina d) {
        return new ResponseEntity(servico.cadastrarDisciplinaNoCurso(id, d), HttpStatus.CREATED);
    }

    @PutMapping("{id}/disciplinas/")
    public ResponseEntity<List<Disciplina>> editarDisciplinaNoCurso(@PathVariable Long id, @RequestBody Disciplina d) {
        return new ResponseEntity(servico.atualizarDisciplina(id, d),HttpStatus.CREATED);
    }

    @DeleteMapping("{id}/disciplinas/{idDisciplina}")
    public ResponseEntity<Void> apagarDisciplina(@PathVariable Long idDisciplina, @PathVariable Long id) {
        servico.deletarDisciplina(id, idDisciplina);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/pesquisar/nome/{nome}")
    public ResponseEntity<List<Disciplina>> listarDisciplinasPorNomeCurso(@PathVariable("nome") String nome) {
        return ResponseEntity.ok(servico.pesquisarDisciplinaNomeCurso(nome));
    }

    @GetMapping("/pesquisar/{nome}")
    public ResponseEntity<Curso> listarNomeCurso(@PathVariable("nome") String nome) {
        return ResponseEntity.ok(servico.listaCursoNome(nome));
    }
}
