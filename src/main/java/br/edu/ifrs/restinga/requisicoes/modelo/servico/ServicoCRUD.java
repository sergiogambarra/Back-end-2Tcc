package br.edu.ifrs.restinga.requisicoes.modelo.servico;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Entidade;
import br.edu.ifrs.restinga.requisicoes.modelo.exception.NaoEncontradoException;
import br.edu.ifrs.restinga.requisicoes.modelo.rn.RegraNenocio;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class ServicoCRUD<T extends Entidade> {

    public abstract CrudRepository<T, Long> getDAO();

    public abstract RegraNenocio<T> rn();

    @Transactional
    public ResponseEntity<T> cadastrar(T entidade) {
        entidade.setId(Long.valueOf(0));
        rn().validar(entidade);
        return new ResponseEntity(getDAO().save(entidade), HttpStatus.CREATED);
    }

   
    public ResponseEntity<T> listar() {
        return new ResponseEntity(getDAO().findAll(), HttpStatus.OK);
    }

   
    public ResponseEntity<T> atualizar(T entidade) {
        rn().validar(entidade);
        return new ResponseEntity(getDAO().save(entidade), HttpStatus.NO_CONTENT);
    }
    
   
    public ResponseEntity<T> recuperar(Long id) {
        T entidade = getDAO().findById(id).orElseThrow(() -> new NaoEncontradoException());
        return new ResponseEntity(entidade, HttpStatus.OK);
    }

   
    public ResponseEntity<T> excluir(Long id) {
        getDAO().deleteById(id);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }

}
