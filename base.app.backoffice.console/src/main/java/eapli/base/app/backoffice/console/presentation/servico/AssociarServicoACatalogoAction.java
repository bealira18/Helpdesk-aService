package eapli.base.app.backoffice.console.presentation.servico;

import eapli.framework.actions.Action;

public class AssociarServicoACatalogoAction implements Action {

    @Override
    public boolean execute() {
        return new AssociarServicoACatalogoUI().show();
    }

}
