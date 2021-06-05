package eapli.base.persistence.impl.inmemory;

import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.repository.FormularioRepository;
import eapli.base.servicomanagement.domain.Servico;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryFormularioRepository extends InMemoryDomainRepository<Formulario, Integer> implements FormularioRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Formulario procurarPorNome(final String nome) {
        throw new UnsupportedOperationException();
    }
}
