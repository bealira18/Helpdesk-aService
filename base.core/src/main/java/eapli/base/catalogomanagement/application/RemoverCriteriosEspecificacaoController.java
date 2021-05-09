package eapli.base.catalogomanagement.application;

import eapli.base.catalogomanagement.domain.CriteriosEspecificacao;
import eapli.base.catalogomanagement.repository.CriteriosEspecificacaoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class RemoverCriteriosEspecificacaoController {

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
    
     public void removerCriteriosEspecificacao(int idCatalogo){

        CriteriosEspecificacao criteriosEspecificacao = procurarCriteriosEspecificacaoPorIdCatalogo(idCatalogo);

        if(criteriosEspecificacao==null){
            throw new IllegalArgumentException("Este critério de especificação tem um id de Catalogo inválido: " + idCatalogo);
        }else{
            criteriosEspecificacao.mudarEstado(false);
        }

        criteriosEspecificacaoRepository.save(criteriosEspecificacao);
    }*/

}
