package br.edu.ifrs.restinga.requisicoes.modelo.dao;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.PerfilAluno;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
import org.springframework.stereotype.Repository;


@Repository
public interface PerfilAlunoDao extends PaginacaoRepository<PerfilAluno, Long>{
    
    public Usuario findByMatricula(int matricula);
}
