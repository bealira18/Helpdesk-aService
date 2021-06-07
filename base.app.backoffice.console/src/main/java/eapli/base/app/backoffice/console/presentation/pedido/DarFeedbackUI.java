package eapli.base.app.backoffice.console.presentation.pedido;

import eapli.base.colaboradormanagement.application.ColaboradorComUserController;
import eapli.base.colaboradormanagement.application.ListarColaboradoresController;
import eapli.base.colaboradormanagement.application.PesquisarColaboradorController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.pedidomanagement.application.DarFeedbackController;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class DarFeedbackUI extends AbstractUI {

    private final ColaboradorComUserController colaboradorComUserController=new ColaboradorComUserController();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ListarColaboradoresController controllercol=new ListarColaboradoresController();
    private final PesquisarColaboradorController controllerpesqcol=new PesquisarColaboradorController();
    private final DarFeedbackController darFeedbackController=new DarFeedbackController();

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

        Iterable<Pedido> pedidos=darFeedbackController.pedidosFinalizados(numero);

        if(pedidos==null){
            System.out.println("\nNão tem pedidos finalizados!\n");
            return false;
        }

        for(Pedido p : pedidos){
            System.out.println("id: "+p.obterId());
        }

        int id=Console.readInteger("ID pedido pretendido: ");

        while(darFeedbackController.procurarPedido(id,pedidos)==null)
            id=Console.readInteger("ID pedido pretendido: ");

        int feedback=Console.readInteger("Feedback (1 a 5): ");

        while(feedback<1 || feedback>5)
            feedback=Console.readInteger("Feedback (1 a 5): ");

        try{
            darFeedbackController.darFeedback(id,feedback);
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        System.out.println("Feedback guardado com sucesso!");

        return true;
    }

    @Override
    public String headline() {
        return "Dar Feedback de um pedido";
    }

}
