package br.edu.ifrs.restinga.requisicoes.modelo.entidade;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="requisicoes_aproveitamento")
public class RequisicaoAproveitamento extends Requisicao{
        private static final long serialVersionUID = 1L;
    @Transient
    @JsonProperty("tipo")
    private final String tipo ="aproveitamento";
    private  String disciplinasCursadasAnterior;

    public RequisicaoAproveitamento(String disciplinasCursadasAnterior, String parecerServidor, String parecerProfessor, String parecerCoordenador, String deferido, String responsavelPelaRequisicao) {
        super(parecerServidor, parecerProfessor, parecerCoordenador, deferido, responsavelPelaRequisicao);
        this.disciplinasCursadasAnterior = disciplinasCursadasAnterior;
    }


}
