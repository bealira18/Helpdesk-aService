package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.catalogomanagement.application.AssociarEquipaACriteriosEspecificacaoController;
import eapli.framework.actions.Action;

public class AssociarEquipaACriteriosEspecificacaoBootstrapper implements Action {

    private final AssociarEquipaACriteriosEspecificacaoController aecec = new AssociarEquipaACriteriosEspecificacaoController();

    @Override
    public boolean execute() {

        aecec.associarEquipaACriteriosEspecificacao("Catalogo1", "EDC");
        aecec.associarEquipaACriteriosEspecificacao("Catalogo2", "EDF");
        return true;
    }
}