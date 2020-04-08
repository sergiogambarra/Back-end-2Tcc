package br.edu.ifrs.restinga.requisicoes.modelo.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
//Configurando herança
@Inheritance(strategy = InheritanceType.JOINED)

//define o tipo raiz
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME, 
    include = JsonTypeInfo.As.EXISTING_PROPERTY, 
    property = "tipo"
)
@JsonTypeName("requisicao")

//tem que definir as subclasses conhecidas
@JsonSubTypes({
    @JsonSubTypes.Type(
        name = "aproveitamento", 
        value = RequisicaoAproveitamento.class
    ),
    @JsonSubTypes.Type(
        name = "certificacao", 
        value = RequisicaoCertificacao.class
    )
})

public abstract class Requisicao implements Serializable, Entidade {
    
    private static final long serialVersionUID = 1L;
    
    @Transient
    @JsonProperty("tipo")
    private String tipo ="requisicao";

    @Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date dataRequisicao;
     
    private String parecer;
    private String deferido ;
            
    @ManyToOne
    private Disciplina disciplinaSolicitada;
    
    @ManyToOne
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(nullable = false)
    private List<Anexo> anexos;    

    public Requisicao(String parecer, String deferido) {
        this.parecer = parecer;
        this.deferido = deferido;
    }
}
