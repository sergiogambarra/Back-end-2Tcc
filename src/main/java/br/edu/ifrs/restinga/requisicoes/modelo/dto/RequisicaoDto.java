/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.requisicoes.modelo.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jader
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequisicaoDto {
    private String id,nomeUsuario,
     matriculaUsuario,
     data, status,nomeDisciplina;

    public RequisicaoDto(Object[] objects) {
       this.id = objects[0].toString();
       this.nomeUsuario = objects[1].toString();
       this.matriculaUsuario = objects[2].toString();
       this.data = objects[3].toString();
       this.nomeDisciplina = objects[4].toString();
       this.status = objects[5].toString();
      }
    
}
