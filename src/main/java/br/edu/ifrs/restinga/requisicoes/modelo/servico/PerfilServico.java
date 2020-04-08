package br.edu.ifrs.restinga.requisicoes.modelo.servico;

import br.edu.ifrs.restinga.requisicoes.modelo.dao.PerfilDao;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Perfil;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.PerfilAluno;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.PerfilProfessor;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.PerfilServidor;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
import br.edu.ifrs.restinga.requisicoes.modelo.rn.PerfilRN;
import br.edu.ifrs.restinga.requisicoes.modelo.rn.RegraNenocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PerfilServico extends ServicoCRUD<Perfil>{
    
    @Autowired
    private PerfilDao dao;
    
    @Autowired
    private PerfilRN rn;
        
    @Override
    public CrudRepository<Perfil, Long> getDAO() {
        return dao;
    }

    @Override
    public RegraNenocio<Perfil> rn() {
        return rn;
    }
    
     public Perfil salvarPerfil(Usuario u){
        switch (u.getPermissao()) {
            case "SERVIDOR":
                PerfilServidor servidor = (PerfilServidor) u.getPerfil();
                rn.validar(servidor);
                return dao.save(servidor);
            case "PROFESSOR":
                PerfilProfessor professor = (PerfilProfessor) u.getPerfil();
                rn.validar(professor);
                return dao.save(professor);
            case "ALUNO":
                PerfilAluno aluno = (PerfilAluno) u.getPerfil();
                rn.validar(aluno);
                return dao.save(aluno);
                default:
                    return null;
        }
    }

}
