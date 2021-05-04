package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.equipamanagement.application.AssociarColaboradorAEquipaController;
import eapli.base.equipamanagement.application.CriarEquipaController;
import eapli.base.equipamanagement.repository.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.actions.Action;

public class EquipaBootstrapper implements Action {

    private final CriarEquipaController controller = new CriarEquipaController();
    private final AssociarColaboradorAEquipaController acec = new AssociarColaboradorAEquipaController();
    private final ColaboradorRepository colaboradorRepository= PersistenceContext.repositories().colaborador();
    private final EquipaRepository equipaRepository = PersistenceContext.repositories().equipa();


    @Override
    public boolean execute() {

        controller.criarEquipa("EDF", "Equipa dos Fixolas");
        controller.criarEquipa("EDC", "Equipa dos Campeoes");
        acec.associarColaboradorAEquipa(1, 8);
        
        return true;
    }
}
