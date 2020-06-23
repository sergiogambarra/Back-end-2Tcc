package br.edu.ifrs.restinga.requisicoes.modelo.entidade;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "configuracao")
public class ConfiguracaoSistema implements Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAbertura ;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFechamento ;

}
