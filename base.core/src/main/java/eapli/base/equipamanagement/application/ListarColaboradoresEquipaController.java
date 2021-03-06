package eapli.base.equipamanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.domain.Acronimo;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.equipamanagement.repository.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.List;

public class ListarColaboradoresEquipaController {

    private final EquipaRepository equipaRepository= PersistenceContext.repositories().equipa();

    public List<Colaborador> listarColaboradoresEquipa(String acronimo){

        Equipa equipa = procurarEquipaAcronimo(acronimo);

        if(equipa == null){
            throw new IllegalArgumentException("Não existe nenhuma equipa com o acrónimo: " + acronimo);
        }

        return equipa.colaboradores();
    }

    public Equipa procurarEquipaAcronimo(String acronimo){
        return equipaRepository.procurarPorAcronimo(new Acronimo(acronimo));
    }
}