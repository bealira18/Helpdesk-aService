package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.tarefamanagement.application.CriarTarefaAutomaticaController;
import eapli.framework.actions.Action;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TarefaAutomaticaBootstrapper implements Action {

    private final CriarTarefaAutomaticaController controller = new CriarTarefaAutomaticaController();

    @Override
    public boolean execute() {

        controller.criarTarefaAutomatica("decide_vendas",false);
        controller.criarTarefaAutomatica("consulta_ficheiro",false);

        return true;

    }

}
