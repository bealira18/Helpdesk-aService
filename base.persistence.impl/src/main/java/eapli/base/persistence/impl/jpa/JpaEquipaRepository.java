package eapli.base.persistence.impl.jpa;

import eapli.base.domain.Equipa;
import eapli.base.repositories.EquipaRepository;
import eapli.framework.domain.repositories.DomainRepository;

public class JpaEquipaRepository extends BasepaRepositoryBase<Equipa, Integer, Integer> implements DomainRepository<Integer, Equipa>, EquipaRepository {

    public JpaEquipaRepository(){ super("id");}

}
