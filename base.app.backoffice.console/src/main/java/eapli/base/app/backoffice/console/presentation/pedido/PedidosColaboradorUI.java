package eapli.base.app.backoffice.console.presentation.pedido;

import eapli.base.colaboradormanagement.application.ColaboradorComUserController;
import eapli.base.colaboradormanagement.application.ListarColaboradoresController;
import eapli.base.colaboradormanagement.application.PesquisarColaboradorController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.pedidomanagement.application.DarFeedbackController;
import eapli.base.pedidomanagement.application.PedidosColaboradorController;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class PedidosColaboradorUI extends AbstractUI {

    private final ColaboradorComUserController colaboradorComUserController=new ColaboradorComUserController();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ListarColaboradoresController controllercol=new ListarColaboradoresController();
    private final PesquisarColaboradorController controllerpesqcol=new PesquisarColaboradorController();
    private final PedidosColaboradorController pedidosColaboradorController=new PedidosColaboradorController();

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

        List<Pedido> historicoPedidos=pedidosColaboradorController.historicoPedidos(numero);
        List<Pedido> pedidosEmCurso=pedidosColaboradorController.pedidosEmCurso(numero);

        System.out.println("\nHistorico de Pedidos\n");
        for(Pedido p : historicoPedidos){
            System.out.println(p.toString());
        }

        System.out.println("\nPedidos em Curso\n");
        for(Pedido p : pedidosEmCurso){
            System.out.println(p.toString());
        }

        return true;
    }

    @Override
    public String headline() {
        return "Pedidos de um colaborador";
    }

}
