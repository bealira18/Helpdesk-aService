package eapli.base.equipamanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.equipamanagement.domain.Acronimo;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.equipamanagement.repository.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import java.util.Optional;

public class RemoverColaboradorDeEquipaController {

    private final EquipaRepository equipaRepository = PersistenceContext.repositories().equipa();
    private final ColaboradorRepository colaboradorRepository= PersistenceContext.repositories().colaborador();

    public void removerColaboradorDeEquipa(String acronimo, int numero){

        Colaborador colab1 = colaboradorRepository.ofIdentity(new Numero(numero)).get();

        if(colab1==null){
            throw new IllegalArgumentException("Não existe nenhum colaborador com o numero: " + numero);
        }


        Equipa equipa1 = procurarEquipaAcronimo(acronimo);

        if(equipa1 == null){
            throw new IllegalArgumentException("Não existe nenhuma equipa com o acrónimo: " + acronimo);
        }

        removerColaboradorDeEquipa(equipa1, colab1);
    }

    public Equipa removerColaboradorDeEquipa(Equipa equipa, Colaborador colaborador) {

        equipa.removeColaborador(colaborador);

        return equipaRepository.save(equipa);

    }

    public Equipa procurarEquipaAcronimo(String acronimo){
        return equipaRepository.procurarPorAcronimo(new Acronimo(acronimo));
    }
}