package eapli.base.persistence.impl.inmemory;

import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repository.ServicoRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryServicoRepository extends InMemoryDomainRepository<Servico, Integer> implements ServicoRepository {

    static {
        InMemoryInitializer.init();
    }
}
