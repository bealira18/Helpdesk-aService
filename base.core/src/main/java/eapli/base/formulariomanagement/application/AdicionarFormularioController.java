package eapli.base.formulariomanagement.application;

import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.repository.AtributoRepository;
import eapli.base.formulariomanagement.repository.FormularioRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class AdicionarFormularioController {

    private final FormularioRepository formularioRepository= PersistenceContext.repositories().formulario();
    private final AtributoRepository atributoRepository= PersistenceContext.repositories().atributo();

    public Formulario adicionarFormulario(String nome){

        final Formulario novoFormulario=new Formulario(nome);

        return formularioRepository.save(novoFormulario);

    }



}
