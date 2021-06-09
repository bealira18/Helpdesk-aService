package eapli.base.persistence.impl.inmemory;

import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.servicomanagement.repository.WorkflowRepository;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryWorkflowRepository extends InMemoryDomainRepository<Workflow, Integer> implements WorkflowRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<TarefaManual> listarTarefasManuais(int id) {
        throw new UnsupportedOperationException();
    }
}
