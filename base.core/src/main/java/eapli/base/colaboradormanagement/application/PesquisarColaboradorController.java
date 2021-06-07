package eapli.base.colaboradormanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class PesquisarColaboradorController {

    private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaborador();

    public Colaborador procurarColaboradorNumero(int numero){
        return colaboradorRepository.ofIdentity(new Numero(numero)).get();
    }

}
