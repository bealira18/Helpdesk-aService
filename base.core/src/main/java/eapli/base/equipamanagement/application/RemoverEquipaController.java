package eapli.base.equipamanagement.application;

import eapli.base.equipamanagement.domain.Acronimo;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.equipamanagement.repository.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class RemoverEquipaController {
 
    private final EquipaRepository equipaRepository= PersistenceContext.repositories().equipa();

public Equipa procurarEquipaPorAcronimo(String acronimo) {

        Iterable<Equipa> equipas = equipaRepository.findAll();

        Equipa equipa = null;

        for (Equipa eq : equipas) {
            if (eq.acronimo().compareTo(new Acronimo(acronimo)) == 0) {
                equipa = eq;
            }
        }
        return equipa;
    }

   public void removerEquipa(String acronimo){

        Equipa equipa=procurarEquipaPorAcronimo(acronimo);

        if(equipa==null){
            throw new IllegalArgumentException("Esta equipa tem um acrónimo inválido: " + acronimo);
        }else{
            equipa.mudarEstado(false);
        }

        equipaRepository.save(equipa);
    }
}
