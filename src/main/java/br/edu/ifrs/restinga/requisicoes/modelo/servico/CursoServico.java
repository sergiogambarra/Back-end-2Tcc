package br.edu.ifrs.restinga.requisicoes.modelo.servico;

import br.edu.ifrs.restinga.requisicoes.modelo.dao.CursoDao;
import br.edu.ifrs.restinga.requisicoes.modelo.dao.DisciplinaDao;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Curso;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Disciplina;
import br.edu.ifrs.restinga.requisicoes.modelo.rn.CursoRN;
import br.edu.ifrs.restinga.requisicoes.modelo.rn.RegraNenocio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CursoServico extends ServicoCRUD<Curso> {

    @Autowired
    private CursoDao dao;
    @Autowired
    private CursoRN rn;
    @Autowired
    private DisciplinaServico disciplinaServico;
    
    @Autowired
    private DisciplinaDao disciplinaDao;

    @Override
    public CrudRepository<Curso, Long> getDAO() {
        return dao;
    }

    @Override
    public RegraNenocio<Curso> rn() {
        return rn;
    }

    public ResponseEntity<List<Disciplina>> cadastrarDisciplinaNoCurso(Long id, Disciplina d) {
        Curso curso = super.recuperar(id).getBody();
        curso.getDisciplinas().add(d);
        Curso cursoRetorno = dao.save(curso);
        return new ResponseEntity(cursoRetorno.getDisciplinas(), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Curso> atualizar(Curso entidade) {
        return super.atualizar(entidade);
    }

    public ResponseEntity<Curso> listarDisciplinas(Long id) {
        Curso curso = super.recuperar(id).getBody();
        return new ResponseEntity(curso.getDisciplinas(), HttpStatus.OK);
    }

    public void deletarDisciplina(Long id, Long idDisciplina) {
        Curso curso = super.recuperar(id).getBody();
        List<Disciplina> disciplinas = (List<Disciplina>) disciplinaDao.findAll();
        System.out.println(id);
                for (Disciplina disciplina : disciplinas) {
            if (disciplina.getId() == idDisciplina) {
        System.out.println(disciplina.getId());
                curso.getDisciplinas().remove(disciplina);
            }
        }
        dao.save(curso);
    }
    public ResponseEntity<Curso>pesquisarDisciplinaNomeCurso(String nome){
        List<Disciplina> cursoDisciplina = dao.findByNome(nome).getDisciplinas();
        return new ResponseEntity(cursoDisciplina,HttpStatus.OK);
    }
    
}
