package eapli.base.persistence.impl.inmemory;

import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.repository.AtributoRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryAtributoRepository extends InMemoryDomainRepository<Atributo, Integer> implements AtributoRepository {

    static {
        InMemoryInitializer.init();
    }
}
