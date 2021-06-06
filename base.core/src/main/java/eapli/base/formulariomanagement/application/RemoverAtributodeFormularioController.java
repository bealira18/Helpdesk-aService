package eapli.base.formulariomanagement.application;

import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.repository.AtributoRepository;
import eapli.base.formulariomanagement.repository.FormularioRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class RemoverAtributodeFormularioController {

    private final FormularioRepository formularioRepository= PersistenceContext.repositories().formulario();
    private final AtributoRepository atributoRepository= PersistenceContext.repositories().atributo();

    public Formulario verificarFormulario(String nomeFormulario){
        return formularioRepository.procurarPorNome(nomeFormulario);
    }

    public Atributo verificarAtributo(String nomeAtributo){

        return atributoRepository.procurarPorNome(nomeAtributo);
    }

    public Formulario removerAtributoDeFormulario(String nomeFormulario, String nomeAtributo){

        Formulario f=verificarFormulario(nomeFormulario);
        Atributo a=verificarAtributo(nomeAtributo);

        if(f==null)
            throw new IllegalArgumentException("Formulario inválido com nome: "+nomeFormulario);

        if(a==null)
            throw new IllegalArgumentException("Atributo inválido com nome: "+nomeAtributo);

        f.removeAtributo(a);

        return formularioRepository.save(f);

    }

}
