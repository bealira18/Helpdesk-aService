package eapli.base.app.backoffice.console.presentation.pedido;

import eapli.framework.actions.Action;

public class DarFeedbackAction implements Action {

    @Override
    public boolean execute() {
        return new DarFeedbackUI().show();
    }

}
