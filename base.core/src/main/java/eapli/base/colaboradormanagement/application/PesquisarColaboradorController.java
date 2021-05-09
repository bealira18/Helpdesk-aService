package eapli.base.colaboradormanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class PesquisarColaboradorController {

    private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaborador();

    public Colaborador procurarColaboradorPorNumero(int numero) {

        Iterable<Colaborador> colaboradores = colaboradorRepository.findAll();

        Colaborador colaborador = null;

        for (Colaborador c : colaboradores) {
            if (c.obterNumero().obterNumero() == numero) {
                colaborador = c;
            }
        }
        return colaborador;
    }

}
