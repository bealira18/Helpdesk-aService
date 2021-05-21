package eapli.base.tarefamanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.domain.TarefaAutomatica;
import eapli.base.tarefamanagement.repository.TarefaRepository;
import java.util.Date;

public class CriarTarefaAutomaticaController {

    private final TarefaRepository tarefaRepository = PersistenceContext.repositories().tarefa();

    public TarefaAutomatica criarTarefaAutomatica(Date dataLimite, int tempo, int prioridade) {

        final TarefaAutomatica novaTarefaAutomatica = new TarefaAutomatica(dataLimite, tempo, prioridade);

        return tarefaRepository.save(novaTarefaAutomatica);

    }
}
