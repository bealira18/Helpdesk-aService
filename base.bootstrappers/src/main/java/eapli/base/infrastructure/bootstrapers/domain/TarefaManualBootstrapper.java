package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.tarefamanagement.application.CriarTarefaManualController;
import eapli.framework.actions.Action;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TarefaManualBootstrapper implements Action {

    private final CriarTarefaManualController controller = new CriarTarefaManualController();

    @Override
    public boolean execute() {

        controller.criarTarefaManual("descricao",true);
        controller.criarTarefaManual("descricao",true);
        controller.criarTarefaManual("descricao",true);

        return true;

    }

}
