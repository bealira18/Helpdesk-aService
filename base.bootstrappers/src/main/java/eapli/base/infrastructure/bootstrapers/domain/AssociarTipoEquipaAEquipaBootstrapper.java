package eapli.base.infrastructure.bootstrapers.domain;


import eapli.base.equipamanagement.application.AssociarTipoEquipaAEquipaController;
import eapli.framework.actions.Action;

public class AssociarTipoEquipaAEquipaBootstrapper implements Action {

    private final AssociarTipoEquipaAEquipaController associarController=new AssociarTipoEquipaAEquipaController();

    @Override
    public boolean execute() {

        associarController.associarTipoEquipaAEquipa("ERecursos","Tipo Equipa 1");
        associarController.associarTipoEquipaAEquipa("EReparacoes","Tipo Equipa 2");

        return true;
    }

}