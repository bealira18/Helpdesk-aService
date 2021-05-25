package eapli.base.app.backoffice.console.presentation.tarefa;

import eapli.framework.actions.Action;


public class CriarTarefaAction implements Action {

    @Override
    public boolean execute() {
        return new CriarTarefaUI().show();
    }

}
