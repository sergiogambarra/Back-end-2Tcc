package br.edu.ifrs.restinga.requisicoes.config;


import br.edu.ifrs.restinga.requisicoes.modelo.servico.JwtServico;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.UsuarioServico;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;


public class JwtFilterConfig extends OncePerRequestFilter {

    @Value("${security.tipo.token}")
    private String TIPO_TOKEN;
    @Value("${security.header}")
    private String TIPO_HEADER;

    private final UsuarioServico usuarioServico;
    private final JwtServico jwtService;

    public JwtFilterConfig(UsuarioServico usuarioServico, JwtServico jwtService) {
        this.usuarioServico = usuarioServico;
        this.jwtService = jwtService;
    }
    
    
    @Override
    protected void doFilterInternal(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            FilterChain filterChain) throws ServletException, IOException {

        String authorization = httpServletRequest.getHeader(TIPO_HEADER);

        if(authorization != null && authorization.startsWith(TIPO_TOKEN)){
            String token = authorization.split(" ")[1];
            if (jwtService.tokenIsValido(token)){
                UserDetails userDetails = usuarioServico.loadUserByUsername(jwtService.obterUsuario(token).getUsername());
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
