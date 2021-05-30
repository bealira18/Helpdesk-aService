package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.servicomanagement.application.AdicionarWorkflowController;
import eapli.framework.actions.Action;

public class AddWorkflowBootstrapper implements Action {

    AdicionarWorkflowController awc = new AdicionarWorkflowController();

    @Override
    public boolean execute() {

        awc.adicionarWorkflow(1, 4);
        awc.adicionarWorkflow(2, 5);
        awc.adicionarWorkflow(3, 6);

        /*Workflow w1=new Workflow(1,1);
        Workflow w2=new Workflow(1,2);
        Workflow w3=new Workflow(1,3);
        repository.save(w1);
        repository.save(w2);
        repository.save(w3);*/
        return true;
    }

}

