package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.Titulo;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.base.colaboradormanagement.domain.Numero;
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
    public Catalogo procurarPorTitulo(final Titulo titulo) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Catalogo> listarCatalogosColaborador(final Numero numero) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Catalogo procurarCatalogoPorIdServico(final int idServico) {
        throw new UnsupportedOperationException();
    }
}
