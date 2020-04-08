package br.edu.ifrs.restinga.requisicoes.controle;

import br.edu.ifrs.restinga.requisicoes.modelo.dto.TokenDto;
import br.edu.ifrs.restinga.requisicoes.modelo.dto.UsuarioDto;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
import br.edu.ifrs.restinga.requisicoes.modelo.exception.SenhaInvalidaException;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.JwtServico;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.UsuarioServico;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin
@RestController
@Api("Api : Login")
@RequestMapping("/api/login/")
public class LoginControle {
    
    @Autowired
    private UsuarioServico usuarioServico;
    
    @Autowired
    private JwtServico jwtServico;
    
   
   
    @PostMapping
    @ApiOperation(value = "Logar no sistema.",response = TokenDto.class)
    public TokenDto autenticar(@RequestBody UsuarioDto user){
        try {
            Usuario usuario = usuarioServico.autenticar(user);
            return  new TokenDto(jwtServico.gerarToken(usuario),usuario);
        }catch (UsernameNotFoundException | SenhaInvalidaException e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,e.getMessage());
        }
    }
}
