package eapli.base.app.backoffice.console.presentation.servico;

import eapli.framework.actions.Action;

public class PesquisarServicoAction implements Action {

    @Override
    public boolean execute() {
        return new PesquisarServicoUI().show();
    }

}
