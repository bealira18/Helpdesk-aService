package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.catalogomanagement.application.AdicionarCatalogoController;
import eapli.base.catalogomanagement.application.EditarCatalogoController;
import eapli.base.catalogomanagement.application.RemoverCatalogoController;
import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.colaboradormanagement.application.AdicionarColaboradorController;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.framework.actions.Action;

import java.util.Date;

public class CatalogoBootstrapper implements Action {

    private final AdicionarCatalogoController addController=new AdicionarCatalogoController();

    @Override
    public boolean execute() {

        addController.adicionarCatalogo("Catalogo1","breve catalogo 1","descricao completa catalogo 1",8,"catalogo1.jpg");
        addController.adicionarCatalogo("Catalogo2","breve catalogo 2","descricao completa catalogo 2",36,"catalogo2.jpg");

        return true;
    }

}
