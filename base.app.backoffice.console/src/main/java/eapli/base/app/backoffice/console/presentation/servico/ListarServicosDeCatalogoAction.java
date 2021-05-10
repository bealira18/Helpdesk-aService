package eapli.base.app.backoffice.console.presentation.servico;

import eapli.framework.actions.Action;

public class ListarServicosDeCatalogoAction implements Action {

    @Override
    public boolean execute() {
        return new ListarServicosDeCatalogoUI().show();
    }

}
