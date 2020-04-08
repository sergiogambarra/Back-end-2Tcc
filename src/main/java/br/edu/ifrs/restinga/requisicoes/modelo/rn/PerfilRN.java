package br.edu.ifrs.restinga.requisicoes.modelo.rn;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Perfil;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.PerfilAluno;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.PerfilProfessor;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.PerfilServidor;
import org.springframework.stereotype.Component;

@Component
public class PerfilRN implements RegraNenocio<Perfil>{

    @Override
    public void validar(Perfil entidade) {
        if(entidade instanceof PerfilAluno){
            this.validaAluno((PerfilAluno) entidade);
        }else if(entidade instanceof PerfilProfessor){
            this.validaProfessor((PerfilProfessor) entidade);
        }else{
            this.validaServidor((PerfilServidor) entidade);
        }
    }
    
    private void validaAluno(PerfilAluno a){
        validaCampo(a.getNome(),"Nome");
        validaCampo(a.getEmail(), "Email");
        validaInteiro(a.getMatricula(), "Matricula");
        validaData(a.getDataIngresso(), "DataIngresso");
        validaCampo(a.getTipo(), "Tipo");
    }
    
    private void validaProfessor(PerfilProfessor p){
        validaCampo(p.getNome(), "Nome");
        validaInteiro(p.getSiape(),"Siape");
        validaCampo(p.getTipo(), "Tipo");
    }
    private void validaServidor(PerfilServidor s){
        validaCampo(s.getCargo(),"Cargo");
        validaCampo(s.getNome(),"Nome");
        validaInteiro(s.getSiape(),"Siape");
        validaCampo(s.getTipo(), "Tipo");
    }
}
