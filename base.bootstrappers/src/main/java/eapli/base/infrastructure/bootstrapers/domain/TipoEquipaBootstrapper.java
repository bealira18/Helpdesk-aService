package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.equipamanagement.application.AdicionarTipoEquipaController;
import eapli.framework.actions.Action;

public class TipoEquipaBootstrapper implements Action {

    private final AdicionarTipoEquipaController addController=new AdicionarTipoEquipaController();

    @Override
    public boolean execute() {

        addController.adicionarTipoEquipa("Tipo Equipa 1","Descricao 1","#123456");
        addController.adicionarTipoEquipa("Tipo Equipa 2","Descricao 2","#654321");

        return true;
    }

}
