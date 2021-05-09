package eapli.base.app.backoffice.console.presentation.tipoEquipa;

import eapli.framework.actions.Action;

public class PesquisarTipoEquipaAction implements Action {

    @Override
    public boolean execute() {
        return new PesquisarTipoEquipaUI().show();
    }

}
