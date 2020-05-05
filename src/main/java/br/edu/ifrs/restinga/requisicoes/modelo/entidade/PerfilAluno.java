package br.edu.ifrs.restinga.requisicoes.modelo.entidade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "alunos")
public class PerfilAluno extends Perfil  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Transient
    @JsonProperty("tipo")
    private final String tipo = "ALUNO";
    
    private int matricula; 
    @Temporal(TemporalType.DATE)
    private Date dataIngresso;
    
       
    
}
