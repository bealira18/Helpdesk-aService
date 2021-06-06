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

    /*public Formulario verificarFormulario(String nomeFormulario){

        Iterable<Formulario> formularios=formularioRepository.findAll();

        for(Formulario f : formularios){
            if(f.compareTo(nomeFormulario)==0)
                return f;
        }

        return null;
    }*/

    /*public Formulario verificarFormularioId(int id){

        Iterable<Formulario> formularios=formularioRepository.findAll();

        for(Formulario f : formularios){
            if(f.obterId()==id)
                return f;
        }

        return null;
    }*/

    /*public Atributo verificarAtributo(String nomeAtributo){

        Iterable<Atributo> atributos=atributoRepository.findAll();

        for(Atributo a : atributos){
            if(a.obterNome().equals(nomeAtributo)) {
                return a;
            }
        }

        return null;
    }*/

    /*public Atributo verificarAtributoId(int id){

        Iterable<Atributo> atributos=atributoRepository.findAll();

        for(Atributo a : atributos){
            if(a.obterId()==id)
                return a;
        }

        return null;
    }*/

}
