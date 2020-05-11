package br.edu.ifrs.restinga.requisicoes.modelo.rn;

import br.edu.ifrs.restinga.requisicoes.modelo.entidade.Anexo;
import br.edu.ifrs.restinga.requisicoes.modelo.exception.CampoNullException;
import br.edu.ifrs.restinga.requisicoes.modelo.exception.CampoVazioException;
import br.edu.ifrs.restinga.requisicoes.modelo.exception.MensagemErroGenericaException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;


public interface RegraNenocio<T> {
        public void validar(T entidade);
        
        default void validaTamanhoLogin(String campo, String nomeCampo){
            if (campo.length() < 6 || campo.length() > 10 ) throw new MensagemErroGenericaException("Campo "+nomeCampo+ " ter que ter entre 6 e 10 caracteres");
        }
        
        default void validaCampo(String campo,String nomeCampo){
            if (isNull(campo))   throw new CampoNullException(nomeCampo);
            if (campo.isEmpty()) throw new CampoVazioException(nomeCampo);
        }

        default  void validaInteiro(Integer campo, String nomeCampo ){
            if (isNull(campo) || campo <= 0) throw new MensagemErroGenericaException("Campo "+nomeCampo+" não pode ser nullo ou igual 0 !");
        }
        default void validaAnexos(List <Anexo> lista,String nomeCampo){
           if (isNull(lista) )throw new CampoNullException(nomeCampo);
           if (lista.size() <= 0)throw new MensagemErroGenericaException("anexos não pode ser vazio");
        
        }
        default public boolean isNull(Object o){
            return o == null;
        }
        default public void validaData(Date data,String nomeCampo){
            if(isNull(data)) throw new MensagemErroGenericaException("Campo "+nomeCampo+" obrigatório !");
            LocalDateTime localDateTime = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            if(!LocalDateTime.now().isAfter(localDateTime)) throw new MensagemErroGenericaException("Data ingresso inválida verifique !");
        }
        default public void validaEmail(String email){
            if (email.indexOf("@") < 1) throw new MensagemErroGenericaException("Não inseriu email valido");
                     
        }
}
