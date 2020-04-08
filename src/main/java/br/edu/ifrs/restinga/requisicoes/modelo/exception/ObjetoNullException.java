package br.edu.ifrs.restinga.requisicoes.modelo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ObjetoNullException extends RuntimeException{
    public ObjetoNullException(String msg) {
        super("Objeto "+msg+" nulo verifique !");
    }
}
