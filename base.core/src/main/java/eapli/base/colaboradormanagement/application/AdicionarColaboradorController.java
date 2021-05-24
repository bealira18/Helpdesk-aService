package eapli.base.colaboradormanagement.application;

import api.GerarPasse;
import api.SendEmail;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.colaboradormanagement.domain.Passe;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.AddUserController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.domain.model.Role;

import java.util.*;

public class AdicionarColaboradorController {

    AddUserController auc = new AddUserController();

    private final ColaboradorRepository colaboradorRepository= PersistenceContext.repositories().colaborador();

    public Colaborador adicionarColaborador(int numero, String nomeCurto, String nomeCompleto, Date dataNascimento, String localResidencia, boolean serHumano,
                                            String email, String perfilColaborador, String funcao, String contacto){

        final Colaborador novoColaborador=new Colaborador(numero,nomeCurto,nomeCompleto,dataNascimento,localResidencia,serHumano,email,perfilColaborador,funcao,contacto);
        novoColaborador.mudarPasse(new Passe(GerarPasse.gerarPasse()));
        Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.COLABORADOR);
        auc.addUserComPassWord(email, novoColaborador.obterPasse().obterPasse(), nomeCurto, nomeCompleto, email, roles);
        String subject = "Registo no sistema";
        String body = String.format("Você registou-se com sucesso no nosso sistema e a sua password é %s", novoColaborador.obterPasse().obterPasse());
        SendEmail.sendEmail(novoColaborador.obterEmail().obterEmail(), subject, body);

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
