package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.catalogomanagement.application.AssociarCriteriosEspecificacaoACatalogoController;
import eapli.framework.actions.Action;

public class AssociarCriteriosEspecificacaoACatalogoBootstrapper implements Action{

    private final AssociarCriteriosEspecificacaoACatalogoController acecc = new AssociarCriteriosEspecificacaoACatalogoController();

    @Override
    public boolean execute() {

        acecc.associarCriteriosEspecificacaoACatalogo("Catalogo1");
        acecc.associarCriteriosEspecificacaoACatalogo("Catalogo2");

        return true;
    }
}
