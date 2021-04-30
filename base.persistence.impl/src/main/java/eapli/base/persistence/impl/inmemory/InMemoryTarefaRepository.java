package eapli.base.persistence.impl.inmemory;

import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.repository.TarefaRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryTarefaRepository extends InMemoryDomainRepository<Tarefa, Integer> implements TarefaRepository {

    static {
        InMemoryInitializer.init();
    }
}
