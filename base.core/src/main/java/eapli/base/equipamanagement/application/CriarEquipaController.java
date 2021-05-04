package eapli.base.equipamanagement.application;

import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.equipamanagement.repository.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class CriarEquipaController {

    private final EquipaRepository equipaRepository = PersistenceContext.repositories().equipa();

    public Equipa criarEquipa(String acronimo, String designacao) {

        final Equipa novaEquipa = new Equipa(acronimo, designacao);

        return equipaRepository.save(novaEquipa);

    }

}
