package eapli.base.persistence.impl.inmemory;

import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.equipamanagement.repository.EquipaRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryEquipaRepository extends InMemoryDomainRepository<Equipa, Integer> implements EquipaRepository {

    static {
        InMemoryInitializer.init();
    }
}