package eapli.base.persistence.impl.jpa;

import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.repository.TarefaRepository;
import eapli.framework.domain.repositories.DomainRepository;

public class JpaTarefaRepository extends BasepaRepositoryBase<Tarefa, Integer, Integer> implements DomainRepository<Integer, Tarefa>, TarefaRepository {
    
    public JpaTarefaRepository(){ super("id");}
}
