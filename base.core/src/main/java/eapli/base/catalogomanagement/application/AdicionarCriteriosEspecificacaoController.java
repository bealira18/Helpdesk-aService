package eapli.base.catalogomanagement.application;

import eapli.base.catalogomanagement.domain.CriteriosEspecificacao;
import eapli.base.catalogomanagement.repository.CriteriosEspecificacaoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class AdicionarCriteriosEspecificacaoController {

    private final CriteriosEspecificacaoRepository criteriosEspecificacaoRepository = PersistenceContext.repositories().criteriosEspecificacao();

    public CriteriosEspecificacao adicionarCriteriosEspecificacao(int idCatalogo) {

        final CriteriosEspecificacao novoCriterioEspecificacao = new CriteriosEspecificacao(idCatalogo);

        return criteriosEspecificacaoRepository.save(novoCriterioEspecificacao);

    }
}
