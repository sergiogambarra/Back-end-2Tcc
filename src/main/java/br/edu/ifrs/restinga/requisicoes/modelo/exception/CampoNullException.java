package br.edu.ifrs.restinga.requisicoes.modelo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CampoNullException extends RuntimeException{
    public CampoNullException(String msg) {
        super("Campo "+msg+" não pode estar nulo !");
    }
}
