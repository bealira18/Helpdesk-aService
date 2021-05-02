package eapli.base.colaboradormanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.Date;

public class AdicionarColaboradorController {

    private final ColaboradorRepository colaboradorRepository= PersistenceContext.repositories().colaborador();

    public Colaborador adicionarColaborador(int numero, String nomeCurto, String nomeCompleto, Date dataNascimento, String localResidencia, boolean serHumano,
                                            String email, String perfilColaborador, String funcao, long contacto){

        final Colaborador novoColaborador=new Colaborador(numero,nomeCurto,nomeCompleto,dataNascimento,localResidencia,serHumano,"Abc12355",email,perfilColaborador,funcao,null,contacto);

        return colaboradorRepository.save(novoColaborador);

    }

}
