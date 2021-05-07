package eapli.base.infrastructure.bootstrapers.domain;


import eapli.base.equipamanagement.application.AssociarTipoEquipaAEquipaController;
import eapli.framework.actions.Action;

public class AssociarTipoEquipaAEquipaBootstrapper implements Action {

    private final AssociarTipoEquipaAEquipaController associarController=new AssociarTipoEquipaAEquipaController();

    @Override
    public boolean execute() {

        associarController.associarTipoEquipaAEquipa("EDF","tipoequipa1");
        associarController.associarTipoEquipaAEquipa("EDC","tipoequipa2");

        return true;
    }

}