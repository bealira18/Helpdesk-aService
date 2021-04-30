package eapli.base.persistence.impl.jpa;

import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.servicomanagement.repository.WorkflowRepository;
import eapli.framework.domain.repositories.DomainRepository;

public class JpaWorkflowRepository extends BasepaRepositoryBase<Workflow, Integer, Integer> implements DomainRepository<Integer, Workflow>, WorkflowRepository {

    public JpaWorkflowRepository(){ super("id");}

}
