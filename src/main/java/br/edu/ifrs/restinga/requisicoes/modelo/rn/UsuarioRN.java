package br.edu.ifrs.restinga.requisicoes.modelo.rn;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
import br.edu.ifrs.restinga.requisicoes.modelo.exception.MensagemErroGenericaException;
import br.edu.ifrs.restinga.requisicoes.modelo.exception.ObjetoNullException;
import br.edu.ifrs.restinga.requisicoes.modelo.exception.SenhaInvalidaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioRN implements RegraNenocio<Usuario> {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void validar(Usuario u) {
        validaEmail(u.getEmail());
        validaCampo(u.getUsername(), "Login");
        validaCampo(u.getPassword(), "Senha");
        validaCampo(u.getPermissao(), "Permissão");
        validaCampo(u.getEmail(), "E-mail");
        validaTamanhoLogin(u.getUsername(), "Login");
        if (u.getEmail().length() > 40) {
            throw new MensagemErroGenericaException("Limite máximo para cadastro de 40 caracteres");
        }
        if ( u.getPassword().length() > 30) {
            throw new MensagemErroGenericaException("Limite máximo para cadastro de 30 caracteres");
        }
    }

    public void validaLogin(String login, String senha) {
        validaCampo(login, "Login");
        validaCampo(senha, "Senha");
    }

    public void validaUsuarioNaoEncontrado(Usuario u) {
        if (u == null) {
            throw new UsernameNotFoundException("Usuário não encontrado verifique !");
        }
    }

    public void validaSenhaBanco(String senha, UserDetails details) {
        if (!passwordEncoder.matches(senha, details.getPassword())) {
            throw new SenhaInvalidaException();
        }
    }

    private void validaPerfil(Usuario u) {
        validaEmail(u.getEmail());
        if (isNull(u.getPerfil())) {
            throw new ObjetoNullException("Perfil");
        }
    }

}
