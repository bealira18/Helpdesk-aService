package eapli.base.formulariomanagement.application;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.repository.FormularioRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repository.ServicoRepository;

import java.util.ArrayList;
import java.util.List;

public class ListarAtributosDeFormularioController {

    private final FormularioRepository formularioRepository= PersistenceContext.repositories().formulario();

    public Formulario procurarFormularioPorId(int id) {

        Iterable<Formulario> formularios = formularioRepository.findAll();

        Formulario formulario = new Formulario();

        for (Formulario f : formularios) {
            if (f.obterId()==id) {
                formulario = f;
            }
        }
        return formulario;
    }

    public List<Atributo> listarAtributosIncompletosFormulario(int id){

        Formulario formulario=procurarFormularioPorId(id);

        List<Atributo> atributos =formulario.obterAtributos();

        List<Atributo> atributosInc=new ArrayList<>();

        for(Atributo a : atributos){
            if(!a.obterCompleto())
                atributosInc.add(a);
        }

        return atributosInc;
    }

    public List<Atributo> listarAtributosCompletosFormulario(int id){

        Formulario formulario=procurarFormularioPorId(id);

        List<Atributo> atributos =formulario.obterAtributos();

        List<Atributo> atributosInc=new ArrayList<>();

        for(Atributo a : atributos){
            if(a.obterCompleto())
                atributosInc.add(a);
        }

        return atributosInc;
    }

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
