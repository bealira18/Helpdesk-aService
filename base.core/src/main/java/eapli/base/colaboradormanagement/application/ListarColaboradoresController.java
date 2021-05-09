package eapli.base.colaboradormanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class ListarColaboradoresController {

    private final ColaboradorRepository colaboradorRepository= PersistenceContext.repositories().colaborador();

    public Iterable<Colaborador> listarColaboradores(){

        Iterable<Colaborador> colaboradores = colaboradorRepository.findAll();

        if(colaboradores==null)
            throw new IllegalArgumentException("Ainda não existem colaboradores");

        return colaboradores;
    }

}
