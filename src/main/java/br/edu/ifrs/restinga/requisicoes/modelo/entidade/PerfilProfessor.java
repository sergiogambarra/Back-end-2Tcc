package br.edu.ifrs.restinga.requisicoes.modelo.entidade;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "professores")
public class PerfilProfessor extends Perfil  {
       
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Transient
    @JsonProperty("tipo")
    private final String tipo = "PROFESSOR";
    private String siape;
    private boolean coordenador;

    public PerfilProfessor(String siape, String nome) {
        super.setNome(nome);
        this.setSiape(siape);
    }
    
}
