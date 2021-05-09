package eapli.base.app.backoffice.console.presentation.servico;

import eapli.framework.actions.Action;

public class ContinuarServicoAction implements Action {

    @Override
    public boolean execute() {
        return new ContinuarServicoUI().show();
    }

}
