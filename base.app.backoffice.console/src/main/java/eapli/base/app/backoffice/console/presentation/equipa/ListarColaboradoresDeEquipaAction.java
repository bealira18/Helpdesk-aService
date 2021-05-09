package eapli.base.app.backoffice.console.presentation.equipa;

import eapli.framework.actions.Action;

public class ListarColaboradoresDeEquipaAction implements Action {

    @Override
    public boolean execute() {
        return new ListarColaboradoresDeEquipaUI().show();
    }

}
