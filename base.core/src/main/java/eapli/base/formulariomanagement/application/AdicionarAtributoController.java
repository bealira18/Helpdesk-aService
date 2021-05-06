package eapli.base.formulariomanagement.application;

import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.repository.AtributoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class AdicionarAtributoController {

    private final AtributoRepository atributoRepository= PersistenceContext.repositories().atributo();

    public Atributo adicionarAtributo(String nome, String etiqueta, String descricao, String expressaoRegular, String tipoDadosBase){

        final Atributo atributo=new Atributo(nome,etiqueta,descricao,expressaoRegular,tipoDadosBase);

        return atributoRepository.save(atributo);

    }

}
