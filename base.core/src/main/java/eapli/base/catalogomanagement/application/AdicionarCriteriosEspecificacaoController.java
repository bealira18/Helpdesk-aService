package eapli.base.catalogomanagement.application;

import eapli.base.catalogomanagement.domain.CriteriosEspecificacao;
import eapli.base.catalogomanagement.domain.Titulo;
import eapli.base.catalogomanagement.repository.CriteriosEspecificacaoRepository;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.equipamanagement.domain.Acronimo;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.equipamanagement.repository.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class AdicionarCriteriosEspecificacaoController {

    private final CriteriosEspecificacaoRepository criteriosEspecificacaoRepository = PersistenceContext.repositories().criteriosEspecificacao();
    private final EquipaRepository equipaRepository=PersistenceContext.repositories().equipa();

    public CriteriosEspecificacao adicionarCriteriosEspecificacao(String acronimo) {

        final CriteriosEspecificacao novoCriterioEspecificacao = new CriteriosEspecificacao();

        Equipa equipa = procurarEquipaPorAcronimo(acronimo);

        if(equipa==null)
            throw new IllegalArgumentException("Equipa inexistente "+acronimo);

        novoCriterioEspecificacao.addEquipa(equipa);

        return criteriosEspecificacaoRepository.save(novoCriterioEspecificacao);

    }

    public Equipa procurarEquipaPorAcronimo(String acronimo){
        return equipaRepository.procurarPorAcronimo(new Acronimo(acronimo));
    }
}
