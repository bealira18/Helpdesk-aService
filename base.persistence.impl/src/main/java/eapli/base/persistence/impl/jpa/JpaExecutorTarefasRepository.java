package eapli.base.persistence.impl.jpa;

import eapli.base.tarefamanagement.domain.ExecutorTarefas;
import eapli.base.tarefamanagement.repository.ExecutorTarefasRepository;
import eapli.framework.domain.repositories.DomainRepository;

public class JpaExecutorTarefasRepository extends BasepaRepositoryBase<ExecutorTarefas, Integer, Integer> implements DomainRepository<Integer, ExecutorTarefas>, ExecutorTarefasRepository {

    public JpaExecutorTarefasRepository(){ super("id");}
}
