package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.tarefamanagement.application.ReivindicarTarefaController;
import eapli.framework.actions.Action;

public class ReivindicarTarefaBootstrapper implements Action {

    private final ReivindicarTarefaController reivindicarTarefa = new ReivindicarTarefaController();

    @Override
    public boolean execute() {

        reivindicarTarefa.reivindicarTarefaPendente(1, 8);
        reivindicarTarefa.reivindicarTarefaPendente(2, 8);
        reivindicarTarefa.reivindicarTarefaPendente(3, 5);
        reivindicarTarefa.reivindicarTarefaPendente(4, 5);
        reivindicarTarefa.reivindicarTarefaPendente(5, 36);
        reivindicarTarefa.reivindicarTarefaPendente(6, 36);
        reivindicarTarefa.reivindicarTarefaPendente(7, 78);
        reivindicarTarefa.reivindicarTarefaPendente(8, 78);

        return true;
    }
}
