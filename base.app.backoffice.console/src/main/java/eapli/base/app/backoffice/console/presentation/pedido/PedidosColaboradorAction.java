package eapli.base.app.backoffice.console.presentation.pedido;

import eapli.framework.actions.Action;

public class PedidosColaboradorAction implements Action {

    @Override
    public boolean execute() {
        return new PedidosColaboradorUI().show();
    }

}
