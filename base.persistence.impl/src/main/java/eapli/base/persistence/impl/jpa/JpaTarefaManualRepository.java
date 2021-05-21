package eapli.base.persistence.impl.jpa;

import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.base.tarefamanagement.repository.TarefaManualRepository;
import eapli.framework.domain.repositories.DomainRepository;

public class JpaTarefaManualRepository extends BasepaRepositoryBase<TarefaManual, Integer, Integer> implements DomainRepository<Integer, TarefaManual>, TarefaManualRepository {

    public JpaTarefaManualRepository(){ super("id");}

}
