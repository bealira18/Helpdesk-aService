package eapli.base.nivelcriticidademanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.nivelcriticidademanagement.domain.NivelCriticidade;
import eapli.base.nivelcriticidademanagement.repository.NivelCriticidadeRepository;


public class DefinirNivelCriticidadeController {

    private final NivelCriticidadeRepository nivelCriticidadeRepository = PersistenceContext.repositories().nivelCriticidade();

    public NivelCriticidade definirNivelCriticidade(String objetivo, int tempoMaximoA, int tempoMaximoR, int valor, String etiqueta){

        final NivelCriticidade nivelCriticidade = new NivelCriticidade(objetivo, tempoMaximoA, tempoMaximoR, valor, etiqueta);

        return nivelCriticidadeRepository.save(nivelCriticidade);

    }

}
