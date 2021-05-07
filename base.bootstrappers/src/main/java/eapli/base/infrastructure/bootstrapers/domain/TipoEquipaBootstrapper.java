package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.equipamanagement.application.AdicionarTipoEquipaController;
<<<<<<< HEAD
=======
import eapli.base.equipamanagement.application.AssociarTipoEquipaAEquipa;
import eapli.base.equipamanagement.application.EditarTipoEquipaController;
import eapli.base.equipamanagement.domain.TipoEquipa;
import eapli.base.equipamanagement.repository.TipoEquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
>>>>>>> ef9351a5e87d740870287b5fe07e339e95bc549f
import eapli.framework.actions.Action;

public class TipoEquipaBootstrapper implements Action {

    private final AdicionarTipoEquipaController addController=new AdicionarTipoEquipaController();
<<<<<<< HEAD
=======
    private final AssociarTipoEquipaAEquipa associarController=new AssociarTipoEquipaAEquipa();
    //private final EditarTipoEquipaController editarController=new EditarTipoEquipaController();
>>>>>>> ef9351a5e87d740870287b5fe07e339e95bc549f

    @Override
    public boolean execute() {

        addController.adicionarTipoEquipa("tipoequipa1","descricao1","#123456");
        addController.adicionarTipoEquipa("tipoequipa2","descricao2","#654321");

<<<<<<< HEAD
=======
        associarController.associarTipoEquipaAEquipa("EDF","tipoequipa1");
        associarController.associarTipoEquipaAEquipa("EDC","tipoequipa2");

        //editarController.mudarDescricao("tipoequipa1","descricao nova");

>>>>>>> ef9351a5e87d740870287b5fe07e339e95bc549f
        return true;
    }

}
