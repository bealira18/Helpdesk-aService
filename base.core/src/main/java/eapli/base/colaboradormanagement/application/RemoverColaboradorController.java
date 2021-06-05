package eapli.base.colaboradormanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class RemoverColaboradorController {

    private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaborador();

    public Colaborador procurarColaboradorNumero(int numero){
        return colaboradorRepository.ofIdentity(new Numero(numero)).get();
    }

    public void removerColaborador(int numero){

        Colaborador colaborador = procurarColaboradorNumero(numero);

        if(colaborador==null){
            throw new IllegalArgumentException("Este colaborador tem um número inválido: " + numero);
        }else{
            colaborador.mudarEstado(false);
        }

        colaboradorRepository.save(colaborador);
    }

    /*public Colaborador procurarColaboradorPorNumero(int numero) {

        Iterable<Colaborador> colaboradores = colaboradorRepository.findAll();

        Colaborador colaborador = null;

        for (Colaborador c : colaboradores) {
            if (c.obterNumero().obterNumero() == numero) {
                colaborador = c;
            }
        }
        return colaborador;
    }*/
}