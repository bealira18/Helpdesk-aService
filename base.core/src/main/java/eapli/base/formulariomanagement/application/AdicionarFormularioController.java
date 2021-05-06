package eapli.base.formulariomanagement.application;

import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.repository.AtributoRepository;
import eapli.base.formulariomanagement.repository.FormularioRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.List;

public class AdicionarFormularioController {

    private final FormularioRepository formularioRepository= PersistenceContext.repositories().formulario();
    private final AtributoRepository atributoRepository= PersistenceContext.repositories().atributo();

    public Formulario adicionarFormulario(String nome){

        final Formulario novoFormulario=new Formulario(nome);

        return formularioRepository.save(novoFormulario);

    }

    public Formulario associarAtributoAFormulario(String nomeFormulario,String nomeAtributo){

        Formulario f=verificarFormulario(nomeFormulario);
        Atributo a=verificarAtributo(nomeAtributo);

        if(f==null)
            throw new IllegalArgumentException("Formulario inválido com nome: "+nomeFormulario);

        if(a==null)
            throw new IllegalArgumentException("Atributo inválido com nome: "+nomeAtributo);

        f.addAtributo(a);

        return formularioRepository.save(f);

    }

    public Formulario verificarFormulario(String nomeFormulario){

        Iterable<Formulario> formularios=formularioRepository.findAll();

        for(Formulario f : formularios){
            if(f.compareTo(nomeFormulario)==0)
                return f;
        }

        return null;
    }

    public Atributo verificarAtributo(String nomeAtributo){

        Iterable<Atributo> atributos=atributoRepository.findAll();

        for(Atributo a : atributos){
            if(a.compareTo(nomeAtributo)==0)
                return a;
        }

        return null;
    }

}
