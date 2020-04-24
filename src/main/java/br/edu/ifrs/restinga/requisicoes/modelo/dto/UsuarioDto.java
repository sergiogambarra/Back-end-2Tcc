package br.edu.ifrs.restinga.requisicoes.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    
    private String userName;
    private String password;
    
}