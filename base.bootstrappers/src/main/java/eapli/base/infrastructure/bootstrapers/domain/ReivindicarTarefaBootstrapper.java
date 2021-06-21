package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.tarefamanagement.application.ReivindicarTarefaController;
import eapli.framework.actions.Action;

public class ReivindicarTarefaBootstrapper implements Action {

    private final ReivindicarTarefaController reivindicarTarefa = new ReivindicarTarefaController();

    @Override
    public boolean execute() {

        reivindicarTarefa.reivindicarTarefaPendente(1, 8);
        reivindicarTarefa.reivindicarTarefaPendente(3, 5);
        reivindicarTarefa.reivindicarTarefaPendente(4, 36);

        return true;
    }
}
