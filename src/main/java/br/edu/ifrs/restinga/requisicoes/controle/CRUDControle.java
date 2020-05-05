package br.edu.ifrs.restinga.requisicoes.controle;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Entidade;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.ServicoCRUD;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
        return new ResponseEntity(getService().cadastrar(entidade),HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<Iterable<T>> listar() {
        return ResponseEntity.ok(getService().listar());
    }
    
    @PutMapping("{id}")
    public ResponseEntity<T> atualizar(@PathVariable Long id, @RequestBody T entidade){
        entidade.setId(id);
        getService().atualizar(entidade);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        getService().excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<T> recuperar(@PathVariable Long id) {
         return ResponseEntity.ok(getService().recuperar(id));
    }
    
    @GetMapping("paginacao")
    public ResponseEntity<T> paginacao(Pageable p){
        return new ResponseEntity(getService().listarPaginacao(p), HttpStatus.OK);
    }
}