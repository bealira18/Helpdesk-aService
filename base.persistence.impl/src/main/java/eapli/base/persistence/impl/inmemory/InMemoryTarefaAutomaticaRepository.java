package eapli.base.persistence.impl.inmemory;

import eapli.base.tarefamanagement.domain.TarefaAutomatica;
import eapli.base.tarefamanagement.repository.TarefaAutomaticaRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryTarefaAutomaticaRepository extends InMemoryDomainRepository<TarefaAutomatica, Integer> implements TarefaAutomaticaRepository {

    static {
        InMemoryInitializer.init();
    }

}
