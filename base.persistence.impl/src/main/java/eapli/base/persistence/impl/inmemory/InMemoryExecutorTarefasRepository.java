package eapli.base.persistence.impl.inmemory;

import eapli.base.tarefamanagement.domain.ExecutorTarefas;
import eapli.base.tarefamanagement.repository.ExecutorTarefasRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryExecutorTarefasRepository extends InMemoryDomainRepository<ExecutorTarefas, Integer> implements ExecutorTarefasRepository {

    static {
        InMemoryInitializer.init();
    }
}