package eapli.base.catalogomanagement.application;

import eapli.base.catalogomanagement.domain.CriteriosEspecificacao;
import eapli.base.catalogomanagement.domain.Titulo;
import eapli.base.catalogomanagement.repository.CriteriosEspecificacaoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class EditarCriteriosEspecificacaoController {

    private final CriteriosEspecificacaoRepository criteriosEspecificacaoRepository = PersistenceContext.repositories().criteriosEspecificacao();

    /*public CriteriosEspecificacao procurarCriteriosEspecificacaoPorId(int id) {

        Iterable<CriteriosEspecificacao> criterios = criteriosEspecificacaoRepository.findAll();

        CriteriosEspecificacao criterio = procurarCriteriosEspecificacaoID(id);

        for (CriteriosEspecificacao crit : criterios) {
            if (crit.obterId() == id) {
                criterio = crit;
            }
        }
        return criterio;
    }*/

    public void mudarEstado(int id, Boolean ativo){
        CriteriosEspecificacao ce = procurarCriteriosEspecificacaoID(id);

        if(ce==null){
            throw new IllegalArgumentException("Critérios de especificação inválidos com id: "+id);
        }else{
            ce.mudarEstado(ativo);
        }

        criteriosEspecificacaoRepository.save(ce);
    }

    public CriteriosEspecificacao procurarCriteriosEspecificacaoID(int id){
        return criteriosEspecificacaoRepository.ofIdentity(id).get();
    }
}
