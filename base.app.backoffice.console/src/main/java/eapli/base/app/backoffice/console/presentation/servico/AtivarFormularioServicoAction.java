package eapli.base.app.backoffice.console.presentation.servico;

import eapli.framework.actions.Action;

public class AtivarFormularioServicoAction implements Action {

    @Override
    public boolean execute() {
        return new AtivarFormularioServicoUI().show();
    }

}
