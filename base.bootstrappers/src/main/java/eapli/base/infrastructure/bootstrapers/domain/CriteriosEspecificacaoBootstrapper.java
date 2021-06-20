package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.catalogomanagement.application.AdicionarCriteriosEspecificacaoController;
import eapli.framework.actions.Action;

public class CriteriosEspecificacaoBootstrapper implements Action {

    private final AdicionarCriteriosEspecificacaoController controller = new AdicionarCriteriosEspecificacaoController();

    @Override
    public boolean execute() {

        controller.adicionarCriteriosEspecificacao("ERecursos");
        controller.adicionarCriteriosEspecificacao("EReparacoes");

        return true;
    }

}
