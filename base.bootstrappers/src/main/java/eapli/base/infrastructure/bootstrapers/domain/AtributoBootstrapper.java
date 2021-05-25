package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.formulariomanagement.application.AdicionarAtributoController;
import eapli.base.formulariomanagement.application.AssociarAtributoAFormularioController;
import eapli.framework.actions.Action;

public class AtributoBootstrapper implements Action {

    private final AdicionarAtributoController adicionarAtributoController=new AdicionarAtributoController();
    private final AssociarAtributoAFormularioController associarAtributoAFormularioController=new AssociarAtributoAFormularioController();

    @Override
    public boolean execute() {

        adicionarAtributoController.adicionarAtributo("CC","num","Numero do CC","[0-9]{9}","Integer");

        associarAtributoAFormularioController.associarAtributoAFormulario("Formulario1","CC");

        return true;
    }

}
