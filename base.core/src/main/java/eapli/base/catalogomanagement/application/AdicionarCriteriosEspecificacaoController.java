package eapli.base.catalogomanagement.application;

import eapli.base.catalogomanagement.domain.CriteriosEspecificacao;
import eapli.base.catalogomanagement.repository.CriteriosEspecificacaoRepository;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.equipamanagement.repository.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class AdicionarCriteriosEspecificacaoController {

    private final CriteriosEspecificacaoRepository criteriosEspecificacaoRepository = PersistenceContext.repositories().criteriosEspecificacao();
    private final EquipaRepository equipaRepository=PersistenceContext.repositories().equipa();

    public CriteriosEspecificacao adicionarCriteriosEspecificacao(String acronimo) {

        final CriteriosEspecificacao novoCriterioEspecificacao = new CriteriosEspecificacao();

        Equipa equipa = null;
        Iterable<Equipa> equipas=equipaRepository.findAll();

        if(equipas==null)
            throw new IllegalArgumentException("Ainda não existem equipas");
        else {
            for (Equipa e : equipas) {
                if (e.acronimo().comparar(acronimo) == 0)
                    equipa = e;
            }
        }
        
        if(equipa==null)
            throw new IllegalArgumentException("Equipa inexistente "+acronimo);

        novoCriterioEspecificacao.addEquipa(equipa);

        return criteriosEspecificacaoRepository.save(novoCriterioEspecificacao);

    }
}
