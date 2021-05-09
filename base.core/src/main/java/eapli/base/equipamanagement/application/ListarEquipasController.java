package eapli.base.equipamanagement.application;

import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.equipamanagement.repository.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class ListarEquipasController {

    private final EquipaRepository equipaRepository= PersistenceContext.repositories().equipa();

    public Iterable<Equipa> listarEquipas(){

        Iterable<Equipa> equipas = equipaRepository.findAll();

        if(equipas==null)
            throw new IllegalArgumentException("Ainda não existem equipas");

        return equipas;
    }

}
