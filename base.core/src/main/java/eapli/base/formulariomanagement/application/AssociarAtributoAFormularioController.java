package eapli.base.formulariomanagement.application;

import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.repository.AtributoRepository;
import eapli.base.formulariomanagement.repository.FormularioRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class AssociarAtributoAFormularioController {

    private final FormularioRepository formularioRepository= PersistenceContext.repositories().formulario();
    private final AtributoRepository atributoRepository= PersistenceContext.repositories().atributo();

    public Formulario associarAtributoAFormulario(String nomeFormulario, String nomeAtributo){

        Formulario f=verificarFormularioNome(nomeFormulario);
        Atributo a=verificarAtributoNome(nomeAtributo);

        if(f==null)
            throw new IllegalArgumentException("Formulario inválido com nome: "+nomeFormulario);

        if(a==null)
            throw new IllegalArgumentException("Atributo inválido com nome: "+nomeAtributo);

        f.addAtributo(a);
        f.mudarNumAtributos(f.obterNumAtributos()+1);

        return formularioRepository.save(f);

    }

    public Formulario associarAtributoAFormularioIds(int idF,int idA){

        Formulario f=verificarFormularioID(idF);
        Atributo a=verificarAtributoID(idA);

        if(f==null)
            throw new IllegalArgumentException("Formulario inválido com id: "+idF);

        if(a==null)
            throw new IllegalArgumentException("Atributo inválido com id: "+idA);

        f.addAtributo(a);
        f.mudarNumAtributos(f.obterNumAtributos()+1);

        return formularioRepository.save(f);

    }

    public Formulario verificarFormularioID(int id){
        return formularioRepository.ofIdentity(id).get();
    }

    public Atributo verificarAtributoID(int id){
        return atributoRepository.ofIdentity(id).get();
    }

    public Formulario verificarFormularioNome(String nome){
        return formularioRepository.procurarPorNome(nome);
    }

    public Atributo verificarAtributoNome(String nome){
        return atributoRepository.procurarPorNome(nome);
    }

}
