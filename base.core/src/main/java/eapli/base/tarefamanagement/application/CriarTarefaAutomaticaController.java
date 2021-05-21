package eapli.base.tarefamanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.domain.TarefaAutomatica;
import eapli.base.tarefamanagement.repository.TarefaAutomaticaRepository;
import eapli.base.tarefamanagement.repository.TarefaRepository;
import java.util.Date;

public class CriarTarefaAutomaticaController {

    private final TarefaAutomaticaRepository tarefaAutomaticaRepository = PersistenceContext.repositories().tarefaAutomatica();

    public TarefaAutomatica criarTarefaAutomatica(Date dataLimite, int tempo, int prioridade) {

        final TarefaAutomatica novaTarefaAutomatica = new TarefaAutomatica(dataLimite, tempo, prioridade);

        return tarefaAutomaticaRepository.save(novaTarefaAutomatica);

    }

    public TarefaAutomatica criarTarefaAutomaticaWorkflow(boolean aprovacao) {

        final TarefaAutomatica novaTarefaAutomatica = new TarefaAutomatica(aprovacao);

        return tarefaAutomaticaRepository.save(novaTarefaAutomatica);

    }

}
