package eapli.base.catalogomanagement.application;

import eapli.base.catalogomanagement.domain.CriteriosEspecificacao;
import eapli.base.catalogomanagement.repository.CriteriosEspecificacaoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class EditarCriteriosEspecificacaoController {

    private final CriteriosEspecificacaoRepository criteriosEspecificacaoRepository = PersistenceContext.repositories().criteriosEspecificacao();

    /*public CriteriosEspecificacao procurarCriteriosEspecificacaoPorIdCatalogo(int idCatalogo) {

        Iterable<CriteriosEspecificacao> criterios = criteriosEspecificacaoRepository.findAll();

        CriteriosEspecificacao criterio = null;

        for (CriteriosEspecificacao crit : criterios) {
            if (crit.obterIdCatalogo() == idCatalogo) {
                criterio = crit;
            }
        }
        return criterio;
    }

    public void mudarIdCatalogo(int idAtual, int idNovo) {

        CriteriosEspecificacao criteriosEspecificacao = procurarCriteriosEspecificacaoPorIdCatalogo(idAtual);

        if (criteriosEspecificacao == null) {
            throw new IllegalArgumentException("Este critério de especificação tem um id inválido: " + idAtual);
        } else {
            criteriosEspecificacao.mudarIdCatalogo(idNovo);
        }

        criteriosEspecificacaoRepository.save(criteriosEspecificacao);
    }*/
}
