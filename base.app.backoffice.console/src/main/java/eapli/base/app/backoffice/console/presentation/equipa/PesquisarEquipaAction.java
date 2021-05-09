package eapli.base.app.backoffice.console.presentation.equipa;

import eapli.framework.actions.Action;

public class PesquisarEquipaAction implements Action {

    @Override
    public boolean execute() {
        return new PesquisarEquipaUI().show();
    }

}
