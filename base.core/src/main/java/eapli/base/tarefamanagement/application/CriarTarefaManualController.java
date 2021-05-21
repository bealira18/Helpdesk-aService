package eapli.base.tarefamanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.base.tarefamanagement.repository.TarefaRepository;
import java.util.Date;

public class CriarTarefaManualController {

    private final TarefaRepository tarefaRepository = PersistenceContext.repositories().tarefa();

    public TarefaManual criarTarefaManual(Date dataLimite, int tempo, int prioridade) {

        final TarefaManual novaTarefaManual = new TarefaManual(dataLimite, tempo, prioridade);

        return tarefaRepository.save(novaTarefaManual);

    }
}
