package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.formulariomanagement.application.AdicionarAtributoController;
import eapli.base.formulariomanagement.application.AdicionarFormularioController;
import eapli.base.formulariomanagement.application.AssociarAtributoAFormularioController;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.repository.AtributoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.formulariomanagement.repository.FormularioRepository;
import eapli.framework.actions.Action;

public class FormularioBootstrapper implements Action{
    
    private final AdicionarFormularioController addFormularioController=new AdicionarFormularioController();
    private final AdicionarAtributoController addAtributoController=new AdicionarAtributoController();
    private final AssociarAtributoAFormularioController associarAtributoAFormularioController=new AssociarAtributoAFormularioController();

    /*@Override
    public boolean execute() {

        repository= PersistenceContext.repositories().formulario();
        Formulario formulario1=new Formulario("formulario1");
        Formulario formulario2=new Formulario("formulario2");
        Formulario formulario3=new Formulario("formulario3");
        repository.save(formulario1);
        repository.save(formulario2);
        repository.save(formulario3);
        return false;
    }*/

    @Override
    public boolean execute() {

        addFormularioController.adicionarFormulario("Formulario1");
        addFormularioController.adicionarFormulario("Formulario2");

        /*addAtributoController.adicionarAtributo("atributo1","etiqueta1","descricao1","expressao regular1","String");
        addAtributoController.adicionarAtributo("atributo2","etiqueta2","descricao2","expressao regular2","Integer");
        addAtributoController.adicionarAtributo("atributo3","etiqueta3","descricao3","expressao regular3","String");

        associarAtributoAFormularioController.associarAtributoAFormulario("Formulario1","atributo1");
        associarAtributoAFormularioController.associarAtributoAFormulario("Formulario1","atributo2");
        associarAtributoAFormularioController.associarAtributoAFormulario("Formulario2","atributo3");*/

        return true;
    }


}
