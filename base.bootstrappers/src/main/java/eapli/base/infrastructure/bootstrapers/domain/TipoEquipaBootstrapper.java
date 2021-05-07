package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.equipamanagement.application.AdicionarTipoEquipaController;
import eapli.framework.actions.Action;

public class TipoEquipaBootstrapper implements Action {

    private final AdicionarTipoEquipaController addController=new AdicionarTipoEquipaController();

    @Override
    public boolean execute() {

        addController.adicionarTipoEquipa("tipoequipa1","descricao1","#123456");
        addController.adicionarTipoEquipa("tipoequipa2","descricao2","#654321");

        return true;
    }

}
