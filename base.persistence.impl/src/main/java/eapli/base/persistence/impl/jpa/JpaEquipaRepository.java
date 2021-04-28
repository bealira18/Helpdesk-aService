package eapli.base.persistence.impl.jpa;

import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.equipamanagement.repository.EquipaRepository;
import eapli.framework.domain.repositories.DomainRepository;

public class JpaEquipaRepository extends BasepaRepositoryBase<Equipa, Integer, Integer> implements DomainRepository<Integer, Equipa>, EquipaRepository {

    public JpaEquipaRepository(){ super("id");}

}
