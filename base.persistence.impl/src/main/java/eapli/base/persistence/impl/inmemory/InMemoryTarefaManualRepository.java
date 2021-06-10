package eapli.base.persistence.impl.inmemory;

import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.base.tarefamanagement.repository.TarefaManualRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryTarefaManualRepository extends InMemoryDomainRepository<TarefaManual, Integer> implements TarefaManualRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<InfoTarefa> procurarTarefasManuaisNaoAtribuidas() {
        throw new UnsupportedOperationException();
    }

}
