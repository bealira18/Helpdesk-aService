package eapli.base.persistence.impl.inmemory;

import eapli.base.nivelcriticidademanagement.domain.NivelCriticidade;
import eapli.base.nivelcriticidademanagement.repository.NivelCriticidadeRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryNivelCriticidadeRepository extends InMemoryDomainRepository<NivelCriticidade, Integer> implements NivelCriticidadeRepository {

    static {
        InMemoryInitializer.init();
    }
}
