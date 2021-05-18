package eapli.base.formulariomanagement.application;

import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.repository.AtributoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class AdicionarAtributoController {

    private final AtributoRepository atributoRepository= PersistenceContext.repositories().atributo();

    public Atributo adicionarAtributo(String nome, String etiqueta, String descricao, String expressaoRegular, String tipoDadosBase){

        final Atributo atributo=new Atributo(nome,etiqueta,descricao,expressaoRegular,tipoDadosBase);

        if(!atributo.obterNome().isEmpty() && !atributo.obterEtiqueta().isEmpty() && !atributo.obterDescricao().isEmpty() && !atributo.obterExpressaoRegular().obterExpressaoRegular().isEmpty() && !atributo.obterTipoDadosBase().obterTipoDadosBase().isEmpty()){
            atributo.mudarAtivo(true);
            atributo.mudarCompleto(true);
        }

        return atributoRepository.save(atributo);

    }

}
