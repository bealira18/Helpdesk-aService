package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.Titulo;
import eapli.base.equipamanagement.domain.Acronimo;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.equipamanagement.repository.EquipaRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryEquipaRepository extends InMemoryDomainRepository<Equipa, Integer> implements EquipaRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Equipa procurarPorAcronimo(final Acronimo acronimo) {
        throw new UnsupportedOperationException();
    }
}