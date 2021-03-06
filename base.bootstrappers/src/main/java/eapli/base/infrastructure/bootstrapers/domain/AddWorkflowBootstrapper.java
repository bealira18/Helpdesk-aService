package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.servicomanagement.application.AdicionarWorkflowController;
import eapli.base.servicomanagement.application.AssociarWorkflowAServicoController;
import eapli.framework.actions.Action;

public class AddWorkflowBootstrapper implements Action {

    AdicionarWorkflowController awc = new AdicionarWorkflowController();
    AssociarWorkflowAServicoController awasc = new AssociarWorkflowAServicoController();

    @Override
    public boolean execute() {

        awc.adicionarWorkflow(1, 3);
        awc.adicionarWorkflow(2, 4);
        awc.adicionarWorkflow(5, 7);
        //awc.adicionarWorkflow(3, 6);

        awasc.associarWorkflowAServico(1, "cod1");
        awasc.associarWorkflowAServico(2, "cod2");
        awasc.associarWorkflowAServico(3, "cod3");

        return true;
    }

}

