package br.edu.ifrs.restinga.requisicoes;

import java.io.File;
import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RequisicoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RequisicoesApplication.class, args);
               
                File arquivoCsv = new File("C:\\Users\\jader\\Área de Trabalho\\TCC\\cursos.csv");
                
                try {
                    String linhasArquivo = new String();
                    Scanner leitor = new Scanner(arquivoCsv);
                    while(leitor.hasNext()){
                linhasArquivo = leitor.nextLine();
                System.out.println(linhasArquivo);
                        
                    }
                            
            } catch (Exception e) {
            };
	}
        
}
