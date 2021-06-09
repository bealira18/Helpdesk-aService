package eapli.base.servicomanagement.repository;

import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.framework.domain.repositories.DomainRepository;

public interface WorkflowRepository extends DomainRepository<Integer, Workflow> {
    Iterable<TarefaManual> listarTarefasManuais(int id);
}
