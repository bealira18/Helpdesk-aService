package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.catalogomanagement.application.AdicionarCatalogoController;
import eapli.base.equipamanagement.application.AdicionarTipoEquipaController;
import eapli.base.equipamanagement.domain.TipoEquipa;
import eapli.base.equipamanagement.repository.TipoEquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.actions.Action;

public class TipoEquipaBootstrapper implements Action {

    private final AdicionarTipoEquipaController addController=new AdicionarTipoEquipaController();

    @Override
    public boolean execute() {

        addController.adicionarTipoEquipa("descricao1","#123456");
        addController.adicionarTipoEquipa("descricao2","#654321");

        return true;
    }

}
