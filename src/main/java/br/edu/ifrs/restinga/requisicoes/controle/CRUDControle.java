package br.edu.ifrs.restinga.requisicoes.controle;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Entidade;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.ServicoCRUD;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
public abstract class CRUDControle<T extends Entidade> {

    public abstract ServicoCRUD<T> getService();
    
    @PostMapping
    public ResponseEntity<T> cadastrar(@RequestBody T entidade){
        return getService().cadastrar(entidade);
    }
    
    @GetMapping
    public ResponseEntity<T> listar() {
        return getService().listar();
    }
    
    @PutMapping("{id}")
    public ResponseEntity<T> atualizar(@PathVariable Long id, @RequestBody T entidade){
        entidade.setId(id);
        return getService().atualizar(entidade);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<T> excluir(@PathVariable Long id) {
        return getService().excluir(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<T> recuperar(@PathVariable Long id) {
         return getService().recuperar(id);
    }
}