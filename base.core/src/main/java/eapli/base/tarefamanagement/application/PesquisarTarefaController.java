package eapli.base.tarefamanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.base.tarefamanagement.repository.TarefaManualRepository;

public class PesquisarTarefaController {

    private final TarefaManualRepository tmRepository = PersistenceContext.repositories().tarefaManual();

    public TarefaManual procurarTarefaPorID(int id) {

        Iterable<TarefaManual> tarefas = tmRepository.findAll();

        TarefaManual tarefaManual = null;

        for (TarefaManual tfM : tarefas) {
            if (tfM.obterId() == id) {
                tarefaManual = tfM;
            }
        }
        return tarefaManual;
    }

}
