package eapli.base.persistence.impl.jpa;

import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.servicomanagement.repository.WorkflowRepository;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.framework.domain.repositories.DomainRepository;

import javax.persistence.TypedQuery;

public class JpaWorkflowRepository extends BasepaRepositoryBase<Workflow, Integer, Integer> implements DomainRepository<Integer, Workflow>, WorkflowRepository {

    public JpaWorkflowRepository(){ super("id");}

    @Override
    public Iterable<TarefaManual> listarTarefasManuais(final int id) {
        final TypedQuery<TarefaManual> query = entityManager().createQuery(
                "SELECT DISTINCT tm FROM TarefaManual tm, Servico s, Workflow w WHERE s.id = :ID AND tm IN (SELECT aind FROM Workflow w JOIN w.tarefas aind)",
                TarefaManual.class);
        query.setParameter("ID", id);

        return query.getResultList();
    }
}
