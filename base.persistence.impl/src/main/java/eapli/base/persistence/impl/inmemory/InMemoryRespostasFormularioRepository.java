package eapli.base.persistence.impl.inmemory;

import eapli.base.formulariomanagement.domain.RespostasFormulario;
import eapli.base.formulariomanagement.repository.RespostasFormularioRepository;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryRespostasFormularioRepository extends InMemoryDomainRepository<RespostasFormulario, Integer> implements RespostasFormularioRepository {

    static {
        InMemoryInitializer.init();
    }

}
