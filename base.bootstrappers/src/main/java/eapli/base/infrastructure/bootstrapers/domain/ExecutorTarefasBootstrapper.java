package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.tarefamanagement.application.ExecutorTarefasController;
import eapli.framework.actions.Action;


public class ExecutorTarefasBootstrapper implements Action {

    private final ExecutorTarefasController executorTarefasController = new ExecutorTarefasController();

    @Override
    public boolean execute() {

        executorTarefasController.criarExecutorTarefas("Executor1");
        executorTarefasController.criarExecutorTarefas("Executor2");
        executorTarefasController.criarExecutorTarefas("Executor3");

        //executorTarefasController.associarTarefaAExecutorTarefas()

        return true;


    }

}
