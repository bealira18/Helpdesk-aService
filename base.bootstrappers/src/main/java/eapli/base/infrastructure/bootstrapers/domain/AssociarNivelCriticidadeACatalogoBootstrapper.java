package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.catalogomanagement.application.AssociarNivelCriticidadeACatalogoController;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.equipamanagement.application.AssociarColaboradorAEquipaController;
import eapli.base.equipamanagement.application.CriarEquipaController;
import eapli.base.equipamanagement.application.EditarEquipaController;
import eapli.base.equipamanagement.application.RemoverColaboradorDeEquipaController;
import eapli.base.equipamanagement.application.RemoverEquipaController;
import eapli.base.equipamanagement.repository.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.actions.Action;

public class AssociarNivelCriticidadeACatalogoBootstrapper implements Action {

    private final AssociarNivelCriticidadeACatalogoController controller = new AssociarNivelCriticidadeACatalogoController();

    @Override
    public boolean execute() {

        controller.associarNivelCriticidadeACatalogo("Catalogo1", "Ser campeão");
        controller.associarNivelCriticidadeACatalogo("Catalogo2", "Ser doutor");

        return true;
    }
}
