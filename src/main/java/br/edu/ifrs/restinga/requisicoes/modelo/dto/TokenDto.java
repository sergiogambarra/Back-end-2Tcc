package br.edu.ifrs.restinga.requisicoes.modelo.dto;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenDto {
    
    private String tipo;
    private String token;
    private String login;
    private String permissao; 

    public TokenDto(String token, Usuario u) {
        this.tipo = "Bearer";
        this.token = token;
        this.login = u.getUsername();
        this.permissao = u.getPermissao();
    }

}
