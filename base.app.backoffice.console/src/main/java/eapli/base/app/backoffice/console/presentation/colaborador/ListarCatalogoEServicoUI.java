package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.base.catalogomanagement.application.ListarCatálogosEServicosController;
import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.colaboradormanagement.application.ColaboradorComUserController;
import eapli.base.colaboradormanagement.application.ListarColaboradoresController;
import eapli.base.colaboradormanagement.application.PesquisarColaboradorController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class ListarCatalogoEServicoUI extends AbstractUI {

    private final ListarCatálogosEServicosController controller=new ListarCatálogosEServicosController();
    private final ListarColaboradoresController controllercol=new ListarColaboradoresController();
    private final PesquisarColaboradorController controllerpesqcol=new PesquisarColaboradorController();
    private final ColaboradorComUserController colaboradorComUserController=new ColaboradorComUserController();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Override
    protected boolean doShow(){

        int numero=0;

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.COLABORADOR)) {
            numero=colaboradorComUserController.resultColaborador().obterNumero().obterNumero();
        }else{
            //mostrar colaboradores
            Iterable<Colaborador> colaboradores=controllercol.listarColaboradores();

            for(Colaborador c : colaboradores){
                System.out.println(c.obterNumero()+"\n");
            }

            //escolher colaborador

            numero= Console.readInteger("\nNumero pretendido: ");

            while(controllerpesqcol.procurarColaboradorNumero(numero)==null)
                numero=Console.readInteger("Numero colaborador pretendido: ");
        }

        Iterable<Catalogo> catalogos=controller.listarCatálogos(numero);

        System.out.println("Catalogos:\n");

        for(Catalogo c : catalogos)
            System.out.println(c.toString()+"\n");

        Iterable<Servico> servicos=controller.listarServicosDeCatalogo(numero);

        for(Servico s : servicos)
            System.out.println(s.toString()+"\n");

        return true;
    }

    @Override
    public String headline() {
        return "Catalogos que um colaborador tem acesso";
    }

}
