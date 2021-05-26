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

    public void mudarNumAtributos(String nomeFormulario,int num){

        Formulario formulario=verificarFormulario(nomeFormulario);

        if(formulario==null){
            throw new IllegalArgumentException("Formulario inválido com nome: "+nomeFormulario);
        }else{
            formulario.mudarNumAtributos(num);
        }

        formularioRepository.save(formulario);

    }

    public void mudarNome(String nomeAtual,String nomeNovo){

        Formulario formulario=verificarFormulario(nomeAtual);

        if(formulario==null){
            throw new IllegalArgumentException("Formulario inválido com nome: "+nomeAtual);
        }else{
            formulario.mudarNome(nomeNovo);
        }

        formularioRepository.save(formulario);
    }

    public Formulario verificarFormularioId(int id){

        Iterable<Formulario> formularios=formularioRepository.findAll();

        for(Formulario f : formularios){
            if(f.obterId()==id)
                return f;
        }

        return null;
    }

    public void mudarNomeId(int id,String nomeNovo){

        Formulario formulario=verificarFormularioId(id);

        if(formulario==null){
            throw new IllegalArgumentException("Formulario inválido com id: "+id);
        }else{
            formulario.mudarNome(nomeNovo);
        }

        formularioRepository.save(formulario);
    }

}
