package eapli.base.servicomanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.servicomanagement.repository.WorkflowRepository;
import eapli.base.tarefamanagement.domain.Tarefa;

import java.util.List;

public class AdicionarWorkflowController {

    private final WorkflowRepository workflowRepository= PersistenceContext.repositories().workflow();

    public Workflow adicionarWorkflow(List<Tarefa> tarefas){

        final Workflow workflow=new Workflow(tarefas);

        return workflowRepository.save(workflow);
    }

}
