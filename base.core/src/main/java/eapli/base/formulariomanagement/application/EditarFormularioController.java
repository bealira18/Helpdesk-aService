package eapli.base.formulariomanagement.application;

import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.domain.Nome;
import eapli.base.formulariomanagement.repository.FormularioRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class EditarFormularioController {

    private final FormularioRepository formularioRepository= PersistenceContext.repositories().formulario();

    public Formulario verificarFormulario(String nomeFormulario){

        Iterable<Formulario> formularios=formularioRepository.findAll();

        for(Formulario f : formularios){
            if(f.compareTo(nomeFormulario)==0)
                return f;
        }

        return null;
    }

    public void mudarNome(String nomeAtual,String nomeNovo){

        Formulario formulario=verificarFormulario(nomeAtual);

        if(formulario==null){
            throw new IllegalArgumentException("Formulario inválido com nome: "+nomeAtual);
        }else{
            formulario.mudarNome(new Nome(nomeNovo));
        }

        formularioRepository.save(formulario);
    }

}