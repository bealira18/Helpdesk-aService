package eapli.base.persistence.impl.jpa;

import eapli.base.pedidomanagement.domain.Rascunho;
import eapli.base.pedidomanagement.repository.RascunhoRepository;
import eapli.framework.domain.repositories.DomainRepository;

public class JpaRascunhoRepository extends BasepaRepositoryBase<Rascunho, Integer, Integer> implements DomainRepository<Integer, Rascunho>, RascunhoRepository {

    public JpaRascunhoRepository(){ super("id");}

}

