package eapli.base.persistence.impl.jpa;

import eapli.base.pedidomanagement.domain.Historico;
import eapli.base.pedidomanagement.repository.HistoricoRepository;
import eapli.framework.domain.repositories.DomainRepository;

public class JpaHistoricoRepository extends BasepaRepositoryBase<Historico, Integer, Integer> implements DomainRepository<Integer, Historico>, HistoricoRepository {

    public JpaHistoricoRepository(){ super("id");}

}
