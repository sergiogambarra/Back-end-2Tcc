package br.edu.ifrs.restinga.requisicoes.modelo.rn;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Curso;
import br.edu.ifrs.restinga.requisicoes.modelo.exception.MensagemErroGenericaException;
import org.springframework.stereotype.Component;

@Component
public class CursoRN implements RegraNenocio<Curso> {
    
    @Override
    public void validar(Curso entidade) {
        String nome = entidade.getNome().trim();
        validaCampo(nome, "Nome");
        if (nome.length() > 100) {
            throw new MensagemErroGenericaException("Limite máximo de 100 caracteres para cadastro");
        }
        
    }
    
}
