package br.edu.ifrs.restinga.requisicoes.modelo.entidade;

import com.opencsv.bean.CsvBindByName;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "disciplinas")
public class Disciplina implements Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CsvBindByName
    private String nome;
    @CsvBindByName
    private int cargaHoraria;

    public Disciplina(String nome, int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
        this.nome = nome;
    }

}
