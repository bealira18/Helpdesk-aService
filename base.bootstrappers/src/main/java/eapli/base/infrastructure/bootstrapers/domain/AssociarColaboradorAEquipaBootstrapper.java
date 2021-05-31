package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.equipamanagement.application.AssociarColaboradorAEquipaController;
import eapli.framework.actions.Action;

public class AssociarColaboradorAEquipaBootstrapper implements Action {

    private final AssociarColaboradorAEquipaController acec = new AssociarColaboradorAEquipaController();
    //private final RemoverColaboradorDeEquipaController rcec = new RemoverColaboradorDeEquipaController();

    @Override
    public boolean execute() {

        acec.associarColaboradorAEquipa("EDC", 8);
        acec.associarColaboradorAEquipa("EDF", 36);
        acec.associarColaboradorAEquipa("EDF", 5);
        return true;
    }
}
