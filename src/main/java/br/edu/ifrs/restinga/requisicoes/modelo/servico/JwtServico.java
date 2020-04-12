package br.edu.ifrs.restinga.requisicoes.modelo.servico;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class JwtServico {
    @Value("${security.expiracao}")
    private String expiracao;
    @Value("${security.segredo}")
    private String segredo;

    public Claims obterClaims(String token){
        return Jwts
                .parser()
                .setSigningKey(this.segredo)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean tokenIsValido(String token){
        try {
            Claims claims = this.obterClaims(token);
            Date exp = claims.getExpiration();
            LocalDateTime localDateTime = exp.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            return !LocalDateTime.now().isAfter(localDateTime);
        }catch (Exception e){
            return false;
        }
    }

    public Usuario obterUsuario(String token){
        return new Usuario(Long.valueOf(obterClaims(token).get("id").toString()),obterClaims(token).get("user").toString());
    }


    public String gerarToken(Usuario u){
        Long minutosExpiracao = Long.valueOf(this.expiracao);
        LocalDateTime dataExpiracao = LocalDateTime.now().plusMinutes(minutosExpiracao);
        Instant instant = dataExpiracao.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        HashMap<String, Object> clains = new HashMap<>();
        clains.put("id", u.getId());
        clains.put("user", u.getUsername());
        return Jwts
                .builder()
                .setSubject(u.getUsername())
                .setClaims(clains)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512,this.segredo)
                .compact();
    }
}
