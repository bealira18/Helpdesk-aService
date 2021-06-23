package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.catalogomanagement.application.AssociarServicoACatalogoController;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.equipamanagement.application.AssociarColaboradorAEquipaController;
import eapli.base.equipamanagement.application.CriarEquipaController;
import eapli.base.equipamanagement.application.EditarEquipaController;
import eapli.base.equipamanagement.application.RemoverColaboradorDeEquipaController;
import eapli.base.equipamanagement.application.RemoverEquipaController;
import eapli.base.equipamanagement.repository.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.actions.Action;

public class AssociarServicoACatalogoBootstrapper implements Action {

    private final AssociarServicoACatalogoController ascc = new AssociarServicoACatalogoController();

    @Override
    public boolean execute() {

        ascc.associarServicoACatalogo("Catalogo1", "cod1");
        ascc.associarServicoACatalogo("Catalogo1", "cod3");
        ascc.associarServicoACatalogo("Catalogo2", "cod2");
        ascc.associarServicoACatalogo("Catalogo2", "cod4");

        return true;
    }
}