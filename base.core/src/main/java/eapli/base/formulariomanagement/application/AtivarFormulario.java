package eapli.base.formulariomanagement.application;

import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.repository.FormularioRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.List;

public class AtivarFormulario {

    private final FormularioRepository formularioRepository= PersistenceContext.repositories().formulario();

    public Formulario ativar(String nomeFormulario){

        Formulario f=verificarFormulario(nomeFormulario);

        if(f==null)
            throw new IllegalArgumentException("Formulario inválido com nome: "+nomeFormulario);

        List<Atributo> atributos=f.obterAtributos();

        if(atributos==null)
            throw new IllegalArgumentException("Este formulario ainda não contém atributos, não pode ficar ativo");

        for(Atributo a : atributos){
            if(a.obterCompleto()){
                f.mudarAtivo(true);
                f.mudarCompleto(true);
            }
        }

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

}
