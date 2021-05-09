package eapli.base.catalogomanagement.repository;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.framework.domain.repositories.DomainRepository;

public interface CatalogoRepository extends DomainRepository<Integer, Catalogo> {
    Iterable<Catalogo> listarCatalogos();
}
