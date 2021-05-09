package eapli.base.app.backoffice.console.presentation.tipoEquipa;

import eapli.framework.actions.Action;

public class ListarTipoEquipaAction implements Action {

    @Override
    public boolean execute() {
        return new ListarTipoEquipaUI().show();
    }

}
