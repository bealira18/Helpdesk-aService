package eapli.base.app.backoffice.console.presentation.servico;

import eapli.framework.actions.Action;

public class AddAtributoAFormularioAction implements Action {

    @Override
    public boolean execute() {
        return new AddAtributoAFormularioUI().show();
    }

}
