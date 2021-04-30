package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogomanagement.domain.CriteriosEspecificacao;
import eapli.base.catalogomanagement.repository.CriteriosEspecificacaoRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryCriteriosEspecificacaoRepository extends InMemoryDomainRepository<CriteriosEspecificacao, Integer> implements CriteriosEspecificacaoRepository {

    static {
        InMemoryInitializer.init();
    }
}