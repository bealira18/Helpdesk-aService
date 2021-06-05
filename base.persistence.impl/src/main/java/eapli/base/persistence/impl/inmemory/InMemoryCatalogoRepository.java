package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.base.servicomanagement.domain.Servico;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryCatalogoRepository extends InMemoryDomainRepository<Catalogo, Integer> implements CatalogoRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Catalogo> listarCatalogos() {
        return match(Catalogo::obterApresentar);
    }

    @Override
    public Catalogo procurarPorTitulo(final String titulo) {
        throw new UnsupportedOperationException();
    }
}
