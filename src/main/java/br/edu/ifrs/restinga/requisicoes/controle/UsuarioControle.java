package br.edu.ifrs.restinga.requisicoes.controle;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Usuario;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.ServicoCRUD;
import br.edu.ifrs.restinga.requisicoes.modelo.servico.UsuarioServico;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        return servico.cadastrar(u);
    }
    @GetMapping("pesquisa/{userName}")
    public ResponseEntity<Usuario> pesquisaLogin(@PathVariable ("userName") String userName){
        return servico.pesquisaLogin(userName);
    }
}
