package eapli.base.persistence.impl.inmemory;

import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.repository.AtributoRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryAtributoRepository extends InMemoryDomainRepository<Atributo, Integer> implements AtributoRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Atributo procurarPorNome(final String nome) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Atributo> atributosIncompletosFormulario(final int idFormulario) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Atributo> atributosCompletosFormulario(final int idFormulario) {
        throw new UnsupportedOperationException();
    }
}
