package eapli.base.equipamanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.equipamanagement.repository.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import java.util.Optional;

public class AssociarColaboradorAEquipaController {

    private final EquipaRepository equipaRepository = PersistenceContext.repositories().equipa();
    private final ColaboradorRepository colaboradorRepository= PersistenceContext.repositories().colaborador();

    public void associarColaboradorAEquipa(String acronimo, int numero){
        Optional<Colaborador> colaborador = colaboradorRepository.ofIdentity(new Numero(numero));
        if(colaborador.isEmpty()){
            throw new IllegalArgumentException("Não existe nenhum colaborador com o numero: " + numero);
        }
        Colaborador colab1 = colaborador.get();
        Iterable<Equipa> equipas = equipaRepository.findAll();
        Equipa equipa1 = null;
        for (Equipa e : equipas){
            if(e.acronimo().stringAcronimo().equalsIgnoreCase(acronimo)){
                equipa1 = e;
            }
        }
        int idTipoEquipa = equipa1.tipoDeEquipa().obterId();
        if(equipa1 == null){
            throw new IllegalArgumentException("Não existe nenhuma equipa com o acrónimo: " + acronimo);
        }
        for (Equipa e : equipas){
            if(e.tipoDeEquipa().obterId()==idTipoEquipa){
                if(e.colaboradores().contains(colab1)){
                    throw new IllegalArgumentException("O colaborador"+ colab1 +" nao pode ser adicionado a esta equipa porque já pertence a outra equipa do mesmo tipo.");
                }
            }
        }
        associarColaboradorAEquipa(equipa1, colab1);
    }

    public Equipa associarColaboradorAEquipa(Equipa equipa, Colaborador colaborador) {

        equipa.addColaborador(colaborador);

        return equipaRepository.save(equipa);

    }

}