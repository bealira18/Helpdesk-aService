package eapli.base.persistence.impl.jpa;

import eapli.base.tarefamanagement.domain.TarefaAutomatica;
import eapli.base.tarefamanagement.repository.TarefaAutomaticaRepository;
import eapli.framework.domain.repositories.DomainRepository;


public class JpaTarefaAutomaticaRepository extends BasepaRepositoryBase<TarefaAutomatica, Integer, Integer> implements DomainRepository<Integer, TarefaAutomatica>, TarefaAutomaticaRepository {

    public JpaTarefaAutomaticaRepository(){ super("id");}

}
