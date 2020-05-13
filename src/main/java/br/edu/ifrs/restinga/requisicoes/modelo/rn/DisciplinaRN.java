package br.edu.ifrs.restinga.requisicoes.modelo.rn;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Disciplina;
import br.edu.ifrs.restinga.requisicoes.modelo.exception.MensagemErroGenericaException;
import org.springframework.stereotype.Component;

@Component
public class DisciplinaRN implements RegraNenocio<Disciplina>{

    @Override
    public void validar(Disciplina entidade) {
        String nome = entidade.getNome().trim();
        validaCampo(nome, " nome");
        if (entidade.getCargaHoraria() < 15 ) {
        throw new MensagemErroGenericaException("Campo carga horária não pode ser inferior a 15 horas");
        }
    }
}
