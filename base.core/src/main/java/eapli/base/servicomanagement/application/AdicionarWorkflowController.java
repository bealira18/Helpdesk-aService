package eapli.base.servicomanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.servicomanagement.repository.WorkflowRepository;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.repository.TarefaRepository;

import java.util.ArrayList;
import java.util.List;

public class AdicionarWorkflowController {

    private final WorkflowRepository workflowRepository= PersistenceContext.repositories().workflow();
    private final TarefaRepository tarefaRepository = PersistenceContext.repositories().tarefa();

    public Workflow adicionarWorkflow(List<Tarefa> tarefas){

        final Workflow workflow=new Workflow(tarefas);

        return workflowRepository.save(workflow);
    }

    public Workflow adicionarWorkflow(int idTarefa1, int idTarefa2){
        Tarefa tarefa1 = null;
        Tarefa tarefa2 = null;

        Iterable<Tarefa> tarefas = tarefaRepository.findAll();

        for (Tarefa t : tarefas){
            if (t.obterId()==idTarefa1){
                tarefa1 = t;
            }
            if (t.obterId()==idTarefa2){
                tarefa2 = t;
            }
        }

        if(tarefa1 == null){
            throw new IllegalArgumentException("Tarefa inválida com id: "+ idTarefa1);
        }

        if(tarefa2 == null){
            throw new IllegalArgumentException("Tarefa inválida com id: "+ idTarefa2);
        }

        List<Tarefa> tarefas2 = new ArrayList<>();

        Workflow w = new Workflow(tarefas2);

        return workflowRepository.save(w);
    }

}
