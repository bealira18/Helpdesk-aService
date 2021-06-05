package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repository.ServicoRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryServicoRepository extends InMemoryDomainRepository<Servico, Integer> implements ServicoRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Servico> listarServicos() {
        return match(Servico::obterApresentar);
    }

    @Override
    public Servico procurarPorCod(final String cod) {
        throw new UnsupportedOperationException();
    }
}
