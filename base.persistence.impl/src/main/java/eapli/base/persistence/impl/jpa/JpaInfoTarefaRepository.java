package eapli.base.persistence.impl.jpa;

import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.repository.InfoTarefaRepository;
import eapli.framework.domain.repositories.DomainRepository;

public class JpaInfoTarefaRepository extends BasepaRepositoryBase<InfoTarefa, Integer, Integer> implements DomainRepository<Integer, InfoTarefa>, InfoTarefaRepository {

    public JpaInfoTarefaRepository(){ super("id");}

}
