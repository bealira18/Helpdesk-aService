package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.catalogomanagement.application.AdicionarCatalogoController;
import eapli.base.equipamanagement.application.AdicionarTipoEquipaController;
import eapli.base.equipamanagement.application.AssociarTipoEquipaAEquipa;
import eapli.base.equipamanagement.domain.TipoEquipa;
import eapli.base.equipamanagement.repository.TipoEquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.actions.Action;

public class TipoEquipaBootstrapper implements Action {

    private final AdicionarTipoEquipaController addController=new AdicionarTipoEquipaController();
    private final AssociarTipoEquipaAEquipa associarController=new AssociarTipoEquipaAEquipa();

    @Override
    public boolean execute() {

        addController.adicionarTipoEquipa("tipoequipa1","descricao1","#123456");
        addController.adicionarTipoEquipa("tipoequipa2","descricao2","#654321");

        associarController.associarTipoEquipaAEquipa("EDF","tipoequipa1");
        associarController.associarTipoEquipaAEquipa("EDC","tipoequipa2");

        return true;
    }

}
