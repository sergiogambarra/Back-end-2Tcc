package br.edu.ifrs.restinga.requisicoes.modelo.dao;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.ConfiguracaoSistema;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracaoSistemaDao extends PaginacaoRepository<ConfiguracaoSistema, Long> {
    
    @Query(value = "SELECT count(*) FROM configuracao as f WHERE now() Between f.data_abertura and f.data_fechamento;",nativeQuery = true)
    public String validaSistema (); 
}
