package eapli.base.infrastructure.bootstrapers.domain;


import eapli.base.equipamanagement.application.AssociarTipoEquipaAEquipa;
import eapli.framework.actions.Action;

public class AssociarTipoEquipaAEquipaBootstrapper implements Action {

    private final AssociarTipoEquipaAEquipa associarController=new AssociarTipoEquipaAEquipa();

    @Override
    public boolean execute() {

        associarController.associarTipoEquipaAEquipa("EDF","tipoequipa1");
        associarController.associarTipoEquipaAEquipa("EDC","tipoequipa2");

        return true;
    }

}