package eapli.base.catalogomanagement.application;

import eapli.base.catalogomanagement.domain.CriteriosEspecificacao;
import eapli.base.catalogomanagement.repository.CriteriosEspecificacaoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class RemoverCriteriosEspecificacaoController {

    private final CriteriosEspecificacaoRepository criteriosEspecificacaoRepository = PersistenceContext.repositories().criteriosEspecificacao();

    public CriteriosEspecificacao procurarCriteriosEspecificacaoID(int id){
        return criteriosEspecificacaoRepository.ofIdentity(id).get();
    }
    
     public void removerCriteriosEspecificacao(int id){

        CriteriosEspecificacao criteriosEspecificacao = procurarCriteriosEspecificacaoID(id);

        if(criteriosEspecificacao==null){
            throw new IllegalArgumentException("Este critério de especificação tem um id inválido: " + id);
        }else{
            criteriosEspecificacao.mudarEstado(false);
        }

        criteriosEspecificacaoRepository.save(criteriosEspecificacao);
    }

    /*public CriteriosEspecificacao procurarCriteriosEspecificacaoPorId(int id) {

        Iterable<CriteriosEspecificacao> criterios = criteriosEspecificacaoRepository.findAll();

        CriteriosEspecificacao criterio = null;

        for (CriteriosEspecificacao crit : criterios) {
            if (crit.obterId() == id) {
                criterio = crit;
            }
        }
        return criterio;
    }*/
}
