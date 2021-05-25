package eapli.base.app.backoffice.console.presentation.tarefa;

import eapli.framework.actions.Action;

public class ConsultarTarefaAction implements Action {

    @Override
    public boolean execute() {
        return new ConsultarTarefaUI().show();
    }
}
