package eapli.base.persistence.impl.inmemory;

import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.repository.InfoTarefaRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryInfoTarefaRepository extends InMemoryDomainRepository<InfoTarefa, Integer> implements InfoTarefaRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<InfoTarefa> filtarInfoTarefaporIdDoColaborador(final int idColaborador) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<InfoTarefa> tarefasAprovacao(){
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<InfoTarefa> tarefasRealizacao(){
        throw new UnsupportedOperationException();
    }
}
