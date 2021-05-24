package eapli.base.servicomanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.base.tarefamanagement.repository.TarefaManualRepository;

import java.util.ArrayList;
import java.util.List;

public class ListarTarefasManuaisWorkflowController {

    private final TarefaManualRepository tarefaManualRepository= PersistenceContext.repositories().tarefaManual();

    public List<TarefaManual> tarefas(Workflow w){

        List<Tarefa> tarefas=w.obterTarefas();
        Iterable<TarefaManual> tarefasManual=tarefaManualRepository.findAll();
        List<TarefaManual> result=new ArrayList<>();

        for(Tarefa t : tarefas){
            for(TarefaManual tm : tarefasManual){
                if(t.obterId()==tm.obterId()){
                    result.add(tm);
                }
            }
        }
        return result;
    }

}
