package br.edu.ifrs.restinga.requisicoes;

import br.edu.ifrs.restinga.requisicoes.modelo.dao.CursoDao;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Curso;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.CursoServico;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.ServicoCRUD;
import java.io.File;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class RequisicoesApplication extends SpringBootServletInitializer {
    

    
    public static void main(String[] args) {
        SpringApplication.run(RequisicoesApplication.class, args);
       
    }
    
}
