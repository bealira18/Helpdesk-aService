package eapli.base.app.backoffice.console.presentation.tipoEquipa;

import eapli.framework.actions.Action;

public class AddTipoEquipaAction implements Action {

    @Override
    public boolean execute() {
        return new AddTipoEquipaUI().show();
    }

}
