package br.edu.ifrs.restinga.requisicoes.modelo.rn;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Perfil;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.PerfilAluno;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.PerfilProfessor;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.PerfilServidor;
import br.edu.ifrs.restinga.requisicoes.modelo.exception.MensagemErroGenericaException;
import org.springframework.stereotype.Component;

@Component
public class PerfilRN implements RegraNenocio<Perfil>{

    @Override
    public void validar(Perfil entidade) {
        if (entidade.getNome().length() > 40) {
            throw new MensagemErroGenericaException("Limite máximo de cadastro 40 caracteres");
        }
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
        validaCampo(a.getMatricula(), "Matricula");
        validaData(a.getDataIngresso(), "DataIngresso");
        validaCampo(a.getTipo(), "Tipo");
//        if (a.getMatricula()> 99999999) {
//            throw new MensagemErroGenericaException("Matricúla não pode ter número superior a 999999999");
//        }
    }
    
    private void validaProfessor(PerfilProfessor p){
        validaCampo(p.getNome(), "Nome");
        validaCampo(p.getSiape(),"Siape");
        validaCampo(p.getTipo(), "Tipo");
//         if (p.getSiape()> 99999999) {
//            throw new MensagemErroGenericaException("SIAPE não pode ter número superior a 999999999");
//        }
    }
    private void validaServidor(PerfilServidor s){
        validaCampo(s.getCargo(),"Cargo");
        validaCampo(s.getNome(),"Nome");
        validaCampo(s.getSiape(),"Siape");
        validaCampo(s.getTipo(), "Tipo");
//        if (s.getSiape()> 99999999) {
//            throw new MensagemErroGenericaException("SIAPE não pode ter número superior a 999999999");
//        }
    }
}
