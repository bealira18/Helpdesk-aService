package eapli.base.persistence.impl.jpa;

import eapli.base.equipamanagement.domain.TipoEquipa;
import eapli.base.equipamanagement.repository.TipoEquipaRepository;
import eapli.framework.domain.repositories.DomainRepository;

public class JpaTipoEquipaRepository extends BasepaRepositoryBase<TipoEquipa, Integer, Integer> implements DomainRepository<Integer, TipoEquipa>, TipoEquipaRepository {

    public JpaTipoEquipaRepository(){ super("id");}

}
