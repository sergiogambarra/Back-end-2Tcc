/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.requisicoes.controle;

import br.edu.ifrs.restinga.requisicoes.modelo.servico.EmailServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jader
 */
@CrossOrigin
@RestController
public class EmailControle {
    @Autowired
    EmailServico servico;
    

    @GetMapping("/api/email/")
    public ResponseEntity<String> sendEmail(@RequestParam String email) {
        return  new ResponseEntity(servico.enviar(email), HttpStatus.OK);
    }
}
