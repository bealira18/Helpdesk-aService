package eapli.base.app.backoffice.console.presentation.catalogo;

import eapli.framework.actions.Action;

public class ListarCatalogoAction implements Action {

    @Override
    public boolean execute() {
        return new ListarCatalogoUI().show();
    }

}
