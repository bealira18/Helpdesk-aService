package eapli.base.persistence.impl.jpa;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.framework.domain.repositories.DomainRepository;

public class JpaCatalogoRepository extends BasepaRepositoryBase<Catalogo, Integer, Integer> implements DomainRepository<Integer, Catalogo>, CatalogoRepository {

    public JpaCatalogoRepository(){ super("id");}

    @Override
    public Iterable<Catalogo> listarCatalogos() {
        return match("e.apresentar=true");
    }
}
