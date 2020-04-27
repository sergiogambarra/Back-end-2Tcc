package br.edu.ifrs.restinga.requisicoes.modelo.servico;

import br.edu.ifrs.restinga.requisicoes.modelo.dao.CursoDao;
import br.edu.ifrs.restinga.requisicoes.modelo.dao.DisciplinaDao;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Curso;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Disciplina;
import br.edu.ifrs.restinga.requisicoes.modelo.exception.NaoEncontradoException;
import br.edu.ifrs.restinga.requisicoes.modelo.rn.CursoRN;
import br.edu.ifrs.restinga.requisicoes.modelo.rn.RegraNenocio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

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

    public List<Disciplina> cadastrarDisciplinaNoCurso(Long id, Disciplina d) {
        Curso curso = super.recuperar(id);
        curso.getDisciplinas().add(d);
        Curso cursoRetorno = dao.save(curso);
        return cursoRetorno.getDisciplinas();
    }

    @Override
    public Curso atualizar(Curso entidade) {
        List <Disciplina> listarDisciplinas = this.listarDisciplinas(entidade.getId());
        entidade.setDisciplinas(listarDisciplinas);
        return super.atualizar(entidade);
    }
    public Curso atualizarDisciplina(Long id, Disciplina entidade) {
        Curso curso = super.recuperar(id);
        List<Disciplina> disciplinas = curso.getDisciplinas();
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getId() == entidade.getId()) {
                disciplina.setId(disciplina.getId());
                disciplina.setNome(entidade.getNome());
                disciplina.setCargaHoraria(entidade.getCargaHoraria());
              
            } 
        }
        return dao.save(curso);
    
    }

    public List<Disciplina> listarDisciplinas(Long id) {
        Curso curso = super.recuperar(id);
        return curso.getDisciplinas();
    }
    public Disciplina listarDisciplinasPeloID(Long id, Long idDisciplina) {
        Curso curso = super.recuperar(id);
        List<Disciplina> disciplinas = curso.getDisciplinas();
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getId() == idDisciplina) {
                
        return disciplina;
            }
        }
        return null;
 }

    public void deletarDisciplina(Long id, Long idDisciplina) {
        Curso curso = super.recuperar(id);
        List<Disciplina> disciplinas = (List<Disciplina>) disciplinaDao.findAll();
        System.out.println(id);
                for (Disciplina disciplina : disciplinas) {
            if (disciplina.getId() == idDisciplina) {
                curso.getDisciplinas().remove(disciplina);
            }
        }
        dao.save(curso);
    }
    public List<Disciplina> pesquisarDisciplinaNomeCurso(String nome){
        List<Disciplina> cursoDisciplina = dao.findByNome(nome).getDisciplinas();
        return cursoDisciplina;
    }
    public Curso listaCursoNome(String nome){
        return dao.findByNome(nome);
    }

}
