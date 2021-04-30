package eapli.base.persistence.impl.inmemory;

import eapli.base.pedidomanagement.domain.Historico;
import eapli.base.pedidomanagement.repository.HistoricoRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryHistoricoRepository extends InMemoryDomainRepository<Historico, Integer> implements HistoricoRepository {

    static {
        InMemoryInitializer.init();
    }
}
