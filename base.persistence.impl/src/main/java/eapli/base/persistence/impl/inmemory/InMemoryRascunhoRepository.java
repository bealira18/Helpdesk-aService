package eapli.base.persistence.impl.inmemory;

import eapli.base.pedidomanagement.domain.Rascunho;
import eapli.base.pedidomanagement.repository.RascunhoRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryRascunhoRepository extends InMemoryDomainRepository<Rascunho, Integer> implements RascunhoRepository {

    static {
        InMemoryInitializer.init();
    }
}
