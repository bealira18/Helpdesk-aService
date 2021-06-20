package eapli.base.app.backoffice.console.presentation.tarefa;

import eapli.framework.actions.Action;


public class ExecutarTarefaManualAction implements Action {

    @Override
    public boolean execute() {
        return new ExecutarTarefaManualUI().show();
    }

}
