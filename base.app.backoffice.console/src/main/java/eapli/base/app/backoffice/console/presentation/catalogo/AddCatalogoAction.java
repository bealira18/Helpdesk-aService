package eapli.base.app.backoffice.console.presentation.catalogo;

import eapli.framework.actions.Action;

public class AddCatalogoAction implements Action {

    @Override
    public boolean execute() {
        return new AddCatalogoUI().show();
    }

}
