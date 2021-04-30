package eapli.base.persistence.impl.inmemory;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryColaboradorRepository extends InMemoryDomainRepository<Colaborador, Numero> implements ColaboradorRepository {

    static {
        InMemoryInitializer.init();
    }
}
