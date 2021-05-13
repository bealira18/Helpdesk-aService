package eapli.base.tarefamanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.repository.TarefaRepository;
import java.util.Date;

public class CriarTarefaController {

    private final TarefaRepository tarefaRepository = PersistenceContext.repositories().tarefa();

    public Tarefa criarTarefa(Date dataLimite, int tempoDecorridoA, int tempoDecorridoR, String estadoTarefa, int tempo, int prioridade) {

        final Tarefa novaTarefa = new Tarefa(dataLimite, tempoDecorridoA, tempoDecorridoR, estadoTarefa, tempo, prioridade);

        return tarefaRepository.save(novaTarefa);

    }
}
