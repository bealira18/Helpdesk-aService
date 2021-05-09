package eapli.base.equipamanagement.application;

import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.equipamanagement.repository.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class PesquisarEquipaController {

    private final EquipaRepository equipaRepository= PersistenceContext.repositories().equipa();

    public Equipa procurarEquipaPorAcronimo(String acronimo){

        Iterable<Equipa> equipas=equipaRepository.findAll();

        Equipa equipa=null;

        for(Equipa e : equipas){
            if(e.acronimo().comparar(acronimo)==0)
                equipa=e;
        }
        return equipa;
    }

}
