package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.servicomanagement.repository.WorkflowRepository;
import eapli.framework.actions.Action;

public class AddWorkflowBootstrapper implements Action {

    WorkflowRepository repository;

    @Override
    public boolean execute() {

        repository= PersistenceContext.repositories().workflow();
        Workflow w1=new Workflow(1,1,1);
        Workflow w2=new Workflow(1,2,2);
        Workflow w3=new Workflow(1,3,3);
        repository.save(w1);
        repository.save(w2);
        repository.save(w3);
        return false;
    }

}

