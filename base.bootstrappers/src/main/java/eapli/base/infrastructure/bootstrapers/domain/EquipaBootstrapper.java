package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.equipamanagement.application.AssociarColaboradorAEquipaController;
import eapli.base.equipamanagement.application.CriarEquipaController;
import eapli.base.equipamanagement.application.EditarEquipaController;
import eapli.base.equipamanagement.application.RemoverColaboradorDeEquipaController;
import eapli.base.equipamanagement.application.RemoverEquipaController;
import eapli.base.equipamanagement.repository.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.actions.Action;

public class EquipaBootstrapper implements Action {

    private final CriarEquipaController controller = new CriarEquipaController();
    private final AssociarColaboradorAEquipaController acec = new AssociarColaboradorAEquipaController();
    private final RemoverColaboradorDeEquipaController rcec = new RemoverColaboradorDeEquipaController();
    private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaborador();
    private final EquipaRepository equipaRepository = PersistenceContext.repositories().equipa();
    //private final EditarEquipaController editarController=new EditarEquipaController();
    //private final RemoverEquipaController removerController=new RemoverEquipaController();

    @Override
    public boolean execute() {

        controller.criarEquipa("EDF", "Equipa dos Fixolas");
        controller.criarEquipa("EDC", "Equipa dos Campeoes");
        acec.associarColaboradorAEquipa("EDC", 8);
        acec.associarColaboradorAEquipa("EDF", 36);
        //rcec.removerColaboradorDeEquipa("EDC", 8);
        //editarController.mudarAcronimo("EDC","EDP");
        //removerController.removerEquipa("EDF");
        return true;
    }
}
