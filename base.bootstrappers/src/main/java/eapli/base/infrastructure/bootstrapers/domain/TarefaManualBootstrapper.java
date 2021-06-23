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

        //servico 1
        controller.criarTarefaManual("ausencia",true);
        controller.criarTarefaManual("vendas",true);

        controller.criarTarefaManual("valida_ausencia",false);
        controller.criarTarefaManual("valida_alteracoes",false);

        //servico 3
        controller.criarTarefaManual("valida_moradas",false);

        return true;

    }

}
