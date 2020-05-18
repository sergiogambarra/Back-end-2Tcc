/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.requisicoes.modelo.servico;

import br.edu.ifrs.restinga.requisicoes.modelo.dao.UsuarioDao;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
import br.edu.ifrs.restinga.requisicoes.modelo.exception.MensagemErroGenericaException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmailServico {

    @Value("${senha.recuperacao}")
    private String chaveSenha;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioDao dao;

    public String enviar(String email) {
        try {
            String novaSenha = passwordEncoder.encode(chaveSenha + email); 
            Usuario user = dao.findByEmail(email);
            if (user == null || !user.getEmail().equals(email)) {
                throw new MensagemErroGenericaException("Email não cadastrado verifique seu email !");
            }
            user.setPassword(passwordEncoder.encode(novaSenha));
            user.setAlterouSenha(true);
            dao.save(user);
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("jmdmoura@restinga.ifrs.edu.br");
            helper.setTo(user.getEmail());
            helper.setSubject("Recuperação de senha");
            helper.setText(
                    "<html>"
                    + "<body>"
                    + "<p>Login &nbsp;&nbsp;<b>" + user.getUsername() + "</b></p>"
                    + "<p>Senha    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>" + novaSenha + "</b></p>"+
                      "<p style='color:red'> Atenção ao copiar a senha, não selecionar epaços em branco</p>"
                    + "</body>"
                    + "</html>", true);
//            helper.addInline("img",new File("C:/images/SpringSource-logo.jpg"));

            try {
                mailSender.send(message);
                return novaSenha;
            } catch (MailException e) {
                return e.getMessage();
            }
        } catch (MessagingException ex) {
            System.out.println(ex);
            return null;
        }
    }
    public String pesquisaEmail(String email){
        Usuario retorno = dao.findByEmail(email);
        return retorno.getEmail();
    }

}
