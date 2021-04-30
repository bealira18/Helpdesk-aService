package eapli.base.persistence.impl.inmemory;


import eapli.base.equipamanagement.domain.TipoEquipa;
import eapli.base.equipamanagement.repository.TipoEquipaRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryTipoEquipaRepository extends InMemoryDomainRepository<TipoEquipa, Integer> implements TipoEquipaRepository {

    static {
        InMemoryInitializer.init();
    }
}
