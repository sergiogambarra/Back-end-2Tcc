package br.edu.ifrs.restinga.requisicoes.modelo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NaoEncontradoException extends RuntimeException{

    public NaoEncontradoException() {
        super("Recurso solicitado não encontrado !");
    }
}
