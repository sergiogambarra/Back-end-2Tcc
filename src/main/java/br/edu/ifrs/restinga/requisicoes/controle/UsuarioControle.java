package br.edu.ifrs.restinga.requisicoes.controle;

import br.edu.ifrs.restinga.requisicoes.modelo.dao.UsuarioDao;
import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.ServicoCRUD;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.UsuarioServico;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@Api("Api : Usuários")
@RequestMapping("/api/usuarios/")
public class UsuarioControle extends CRUDControle<Usuario> {

    @Autowired
    private UsuarioServico servico;
    
    @Autowired
    private UsuarioDao dao;

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
    @GetMapping("matricula/{matricula}")
    public ResponseEntity<Usuario> listaMatricula(@PathVariable int matricula){
        return new ResponseEntity(servico.listaUsuarioMatricula(matricula),HttpStatus.OK);
    }
    @GetMapping("siape/{siape}")
    public ResponseEntity<Usuario> listaSiape(@PathVariable Integer siape){
        return new ResponseEntity(servico.listaProfessorSiape(siape),HttpStatus.OK);
    }
    
     @GetMapping("auth/")
    public ResponseEntity<Usuario> getAutenticado(Authentication authentication){
        User user =(User) authentication.getPrincipal();
        return new ResponseEntity(servico.pesquisaLogin(user.getUsername()),HttpStatus.OK);
    }
     @PutMapping("senha/{id}")
    public ResponseEntity<Usuario> trocaSenha(@PathVariable long id, @RequestBody Usuario u){
        u.setId(id);
        return new ResponseEntity(servico.atualizarSenha(u),HttpStatus.OK);
    }
    
    @GetMapping("pages")
    public ResponseEntity<Usuario> listarUsuariosPaginacao(Pageable p, @RequestParam String tipo){
        return new ResponseEntity(servico.listarPaginacao(p, tipo),HttpStatus.OK);
    }
    
}
