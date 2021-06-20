package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.equipamanagement.application.CriarEquipaController;
import eapli.framework.actions.Action;

public class EquipaBootstrapper implements Action {

    private final CriarEquipaController controller = new CriarEquipaController();

    @Override
    public boolean execute() {

        controller.criarEquipa("ERecursos", "Equipa dos Recursos");
        controller.criarEquipa("EReparacoes", "Equipa das Reparações");
        return true;
    }
}
