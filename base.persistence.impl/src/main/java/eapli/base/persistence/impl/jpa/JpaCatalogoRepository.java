package eapli.base.persistence.impl.jpa;

import eapli.base.domain.Catalogo;
import eapli.base.repositories.CatalogoRepository;
import eapli.framework.domain.repositories.DomainRepository;

public class JpaCatalogoRepository extends BasepaRepositoryBase<Catalogo, Integer, Integer> implements DomainRepository<Integer, Catalogo>, CatalogoRepository {

    public JpaCatalogoRepository(){ super("id");}
}
