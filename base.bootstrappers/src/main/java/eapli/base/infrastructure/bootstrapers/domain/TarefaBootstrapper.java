package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.equipamanagement.application.CriarEquipaController;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.application.CriarTarefaController;
import eapli.base.tarefamanagement.domain.EstadoTarefa;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.base.tarefamanagement.repository.TarefaRepository;
import eapli.framework.actions.Action;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TarefaBootstrapper implements Action {

    private final CriarTarefaController controller = new CriarTarefaController();

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
        EstadoTarefa estado = null;
        controller.criarTarefa(d1, 10, 15, estado.EM_APROVACAO, 20, 3);
        controller.criarTarefa(d2, 25, 20, estado.CONCLUIDO, 35, 4);
        controller.criarTarefa(d3, 20, 25, estado.SUBMETIDO, 30, 1);
        
        
        return true;
        
        
    }

}
