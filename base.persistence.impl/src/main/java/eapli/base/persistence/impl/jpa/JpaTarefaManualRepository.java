package eapli.base.persistence.impl.jpa;

import eapli.base.servicomanagement.domain.Servico;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.base.tarefamanagement.repository.TarefaManualRepository;
import eapli.framework.domain.repositories.DomainRepository;

import javax.persistence.TypedQuery;

public class JpaTarefaManualRepository extends BasepaRepositoryBase<TarefaManual, Integer, Integer> implements DomainRepository<Integer, TarefaManual>, TarefaManualRepository {

    public JpaTarefaManualRepository(){ super("id");}

    @Override
    public Iterable<InfoTarefa> procurarTarefasManuaisNaoAtribuidas() {
        final TypedQuery<InfoTarefa> query = entityManager().createQuery(
                "SELECT i FROM InfoTarefa i, TarefaManual d WHERE i.tarefa.id=d.id AND i.colaborador=null",
                InfoTarefa.class);

        return query.getResultList();
    }

}
