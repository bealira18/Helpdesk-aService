package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.equipamanagement.application.AssociarColaboradorAEquipaController;
import eapli.framework.actions.Action;

public class AssociarColaboradorAEquipaBootstrapper implements Action {

    private final AssociarColaboradorAEquipaController acec = new AssociarColaboradorAEquipaController();

    @Override
    public boolean execute() {

        acec.associarColaboradorAEquipa("ERecursos", 8);
        acec.associarColaboradorAEquipa("EReparacoes", 36);
        acec.associarColaboradorAEquipa("EReparacoes", 5);
        return true;
    }
}
