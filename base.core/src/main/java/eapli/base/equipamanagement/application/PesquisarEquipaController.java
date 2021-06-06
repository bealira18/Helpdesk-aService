package eapli.base.equipamanagement.application;

import eapli.base.equipamanagement.domain.Acronimo;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.equipamanagement.repository.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class PesquisarEquipaController {

    private final EquipaRepository equipaRepository= PersistenceContext.repositories().equipa();

    public Equipa procurarEquipaPorAcronimo(String acronimo){

        return equipaRepository.procurarPorAcronimo(new Acronimo(acronimo));
    }

}
