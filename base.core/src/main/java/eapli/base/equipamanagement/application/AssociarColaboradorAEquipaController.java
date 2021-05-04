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

    public void associarColaboradorAEquipa(int idEquipa, int numero){
        Optional<Colaborador> colaborador = colaboradorRepository.ofIdentity(new Numero(numero));
        Colaborador colab1 = colaborador.get();
        Optional<Equipa> equipa = equipaRepository.ofIdentity(idEquipa);
        Equipa equipa1 = equipa.get();
        associarColaboradorAEquipa(equipa1, colab1);
    }

    public Equipa associarColaboradorAEquipa(Equipa equipa, Colaborador colaborador) {

        equipa.addColaborador(colaborador);

        return equipaRepository.save(equipa);

    }

}

//ver as verificacoes que tenho que fazer tanto no colaborador como na equipa, depois de saber como ir buscar dados a base de dados