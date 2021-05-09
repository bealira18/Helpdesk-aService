package eapli.base.colaboradormanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdicionarColaboradorController {

    private final ColaboradorRepository colaboradorRepository= PersistenceContext.repositories().colaborador();

    public Colaborador adicionarColaborador(int numero, String nomeCurto, String nomeCompleto, Date dataNascimento, String localResidencia, boolean serHumano,
                                            String email, String perfilColaborador, String funcao, long contacto){

        final Colaborador novoColaborador=new Colaborador(numero,nomeCurto,nomeCompleto,dataNascimento,localResidencia,serHumano,email,perfilColaborador,funcao,contacto);

        return colaboradorRepository.save(novoColaborador);

    }

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

    public List<Numero> mostrarNumerosIndisponiveis(){

        Iterable<Colaborador> colaboradores = colaboradorRepository.findAll();

        List<Numero> numeros=new ArrayList<Numero>();

        for(Colaborador c : colaboradores){
            numeros.add(c.obterNumero());
        }

        return numeros;
    }

}
