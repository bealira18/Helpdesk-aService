package eapli.base.tarefamanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.base.tarefamanagement.repository.TarefaManualRepository;
import java.util.ArrayList;
import java.util.List;

public class ConsultarTarefaController {

    private final TarefaManualRepository tarefaManualRepository = PersistenceContext.repositories().tarefaManual();

    public Iterable<TarefaManual> listarTarefasPendentes() {

        Iterable<TarefaManual> tarefas = tarefaManualRepository.findAll();
        List<TarefaManual> tarefasPendentes = new ArrayList<>();

        for (TarefaManual t : tarefas) {
            if (t.obterColaborador() == null) {
                tarefasPendentes.add(t);
            }
        }

        if (tarefasPendentes == null) {
            throw new IllegalArgumentException("Não existem tarefas pendentes.");
        }

        return tarefasPendentes;
    }

}
