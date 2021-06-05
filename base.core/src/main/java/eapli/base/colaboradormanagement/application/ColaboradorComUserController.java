package eapli.base.colaboradormanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Email;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.Optional;

public class ColaboradorComUserController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private UserSession theSession=null;
    private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaborador();

    public SystemUser obterSystemUser(){

        Optional<SystemUser> us=null;

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.COLABORADOR)) {

            us=authz.loggedinUserWithPermissions(BaseRoles.COLABORADOR);

        }
        return us.get();
    }

    public Colaborador procurarColaboradorEmail(SystemUser us){

        Username username=us.username();

        String email=username.toString();

        return colaboradorRepository.procurarPorEmail(new Email(email));
    }

    public Colaborador resultColaborador(){

        Colaborador c=null;
        SystemUser us=obterSystemUser();
        if(us==null)
            return null;
        else
            c= procurarColaboradorEmail(us);

        return c;
    }

    /*public Colaborador procurarColaborador(SystemUser us){

        Username username=us.username();

        String mail=username.toString();

        Iterable<Colaborador> colaboradores = colaboradorRepository.findAll();

        Colaborador colaborador = null;

        for (Colaborador c : colaboradores) {
            if (c.obterEmail().obterEmail().equals(mail)) {
                colaborador = c;
            }
        }
        return colaborador;
    }*/
}
