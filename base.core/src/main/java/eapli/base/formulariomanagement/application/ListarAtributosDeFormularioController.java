package eapli.base.formulariomanagement.application;

import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.repository.AtributoRepository;
import eapli.base.formulariomanagement.repository.FormularioRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.List;

public class ListarAtributosDeFormularioController {

    private final FormularioRepository formularioRepository= PersistenceContext.repositories().formulario();
    private final AtributoRepository atributoRepository=PersistenceContext.repositories().atributo();

    public Formulario procurarFormularioPorId(int id) {
        return formularioRepository.ofIdentity(id).get();
    }

    public List<Atributo> listarAtributosIncompletosFormulario(int id){
        return (List<Atributo>) atributoRepository.atributosIncompletosFormulario(id);
    }

    public List<Atributo> listarAtributosCompletosFormulario(int id){
        return (List<Atributo>) atributoRepository.atributosCompletosFormulario(id);
    }

    /*public List<Atributo> listarAtributosIncompletosFormulario(int id){

        Formulario formulario=procurarFormularioPorId(id);

        List<Atributo> atributos =formulario.obterAtributos();

        List<Atributo> atributosInc=new ArrayList<>();

        for(Atributo a : atributos){
            if(!a.obterCompleto())
                atributosInc.add(a);
        }

        return atributosInc;
    }*/

    /*public List<Atributo> listarAtributosCompletosFormulario(int id){

        Formulario formulario=procurarFormularioPorId(id);

        List<Atributo> atributos =formulario.obterAtributos();

        List<Atributo> atributosInc=new ArrayList<>();

        for(Atributo a : atributos){
            if(a.obterCompleto())
                atributosInc.add(a);
        }

        return atributosInc;
    }*/

    public Atributo procurarAtributoPorNome(int id,String nome) {

        Iterable<Atributo> atributosForm = listarAtributosIncompletosFormulario(id);

        Atributo atributo = null;

        for (Atributo a : atributosForm) {
            if (a.obterNome().equals(nome)) {
                atributo = a;
            }
        }
        return atributo;
    }
}
