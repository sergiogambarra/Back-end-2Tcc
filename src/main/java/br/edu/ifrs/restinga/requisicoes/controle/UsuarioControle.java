package br.edu.ifrs.restinga.requisicoes.controle;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.ServicoCRUD;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.UsuarioServico;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@Api("Api : Usuários")
@RequestMapping("/api/usuarios/")
public class UsuarioControle extends CRUDControle<Usuario> {

    @Autowired
    private UsuarioServico servico;

    @Override
    public ServicoCRUD<Usuario> getService() {
        return servico;
    }
    
    @PostMapping("alunos/")
    public ResponseEntity<Usuario> cadastroAluno(@RequestBody Usuario u){
        return new ResponseEntity(servico.cadastrar(u),HttpStatus.CREATED);
    }
    
    @PostMapping("servidor/")
    public ResponseEntity<Usuario> cadastroServidor(@RequestBody Usuario u){
        return new ResponseEntity(servico.cadastrar(u),HttpStatus.CREATED);
    }
    
    @GetMapping("pesquisa/{userName}")
    public ResponseEntity<Usuario> pesquisaLogin(@PathVariable ("userName") String userName){
        return  new ResponseEntity(servico.pesquisaLogin(userName), HttpStatus.OK);
    }
<<<<<<< HEAD
    
=======
    @GetMapping("pesquisa/aluno/{userName}")
    public ResponseEntity<Usuario> pesquisaLoginAluno(@PathVariable ("userName") String userName){
        return servico.pesquisaLogin(userName);
    }
>>>>>>> 94e3023c34f73cde333a9655d1d1174b59ecae4c
    @GetMapping("alunos/")
    public ResponseEntity<Usuario> listaAlunos(){
        return new ResponseEntity(servico.listarAluno(),HttpStatus.OK);
    }
    
    @GetMapping("professores/")
    public ResponseEntity<Usuario> listaProfessor(){
        return new ResponseEntity(servico.listarProfessor(),HttpStatus.OK);
    }
    
    @GetMapping("servidores/")
    public ResponseEntity<Usuario> listaServidor(){
        return new ResponseEntity(servico.listarServidor(),HttpStatus.OK);
    }
    
     @GetMapping("auth/")
    public ResponseEntity<Usuario> getAutenticado(Authentication authentication){
        User user =(User) authentication.getPrincipal();
        return new ResponseEntity(servico.pesquisaLogin(user.getUsername()),HttpStatus.OK);
    }
}
