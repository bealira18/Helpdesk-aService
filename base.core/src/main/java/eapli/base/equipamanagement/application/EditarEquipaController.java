package eapli.base.equipamanagement.application;

import eapli.base.equipamanagement.domain.Acronimo;
import eapli.base.equipamanagement.domain.Designacao;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.equipamanagement.repository.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class EditarEquipaController {

    private final EquipaRepository equipaRepository = PersistenceContext.repositories().equipa();

    public Equipa procurarEquipaAcronimo(String acronimo){
        return equipaRepository.procurarPorAcronimo(new Acronimo(acronimo));
    }

    public void mudarAcronimo(String acronimoAtual, String acronimoNovo) {

        Equipa equipa = procurarEquipaAcronimo(acronimoAtual);

        if (equipa == null) {
            throw new IllegalArgumentException("Esta equipa tem um acrónimo inválido: " + acronimoAtual);
        } else {
            equipa.mudarAcronimo(new Acronimo(acronimoNovo));
        }

        equipaRepository.save(equipa);
    }
    
    public void mudarDesignacao(String acronimo,String designacao){

        Equipa equipa=procurarEquipaAcronimo(acronimo);

        if(equipa==null){
            throw new IllegalArgumentException("Esta equipa tem um acrónimo inválido: " + acronimo);
        }else{
            equipa.mudarDesignacao(new Designacao(designacao));
        }

        equipaRepository.save(equipa);
    }

}
