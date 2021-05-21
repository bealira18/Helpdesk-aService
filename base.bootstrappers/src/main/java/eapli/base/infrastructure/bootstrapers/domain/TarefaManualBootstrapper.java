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

        SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = new Date();
        Date d2 = new Date();
        Date d3 = new Date();
        try {
            d1 = forma.parse("24/02/2022");
            d2 = forma.parse("07/08/2024");
            d3 = forma.parse("06/12/2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        controller.criarTarefaManual(d1, 10, 4);
        controller.criarTarefaManual(d2, 25, 3);
        controller.criarTarefaManual(d3, 20, 2);

        return true;

    }

}
