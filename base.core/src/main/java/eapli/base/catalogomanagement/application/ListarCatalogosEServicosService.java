package eapli.base.catalogomanagement.application;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repository.ServicoRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

@ApplicationService
public class ListarCatalogosEServicosService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogo();
    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servico();


    public Iterable<Catalogo> listarCatalogos() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER);

        return this.catalogoRepository.listarCatalogos();
    }

    public Iterable<Servico> listarServicos(){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER);

        return this.servicoRepository.listarServicosIncompletos();
    }
}
