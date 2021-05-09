package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.framework.actions.Action;

public class AssociarColaboradorAEquipaAction implements Action {

    @Override
    public boolean execute() {
        return new AssociarColaboradorAEquipaUI().show();
    }

}
