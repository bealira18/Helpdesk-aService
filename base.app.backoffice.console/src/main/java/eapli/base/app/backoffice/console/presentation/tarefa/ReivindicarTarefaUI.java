package eapli.base.app.backoffice.console.presentation.tarefa;

import eapli.base.colaboradormanagement.application.ColaboradorComUserController;
import eapli.base.colaboradormanagement.application.ListarColaboradoresController;
import eapli.base.colaboradormanagement.application.PesquisarColaboradorController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.tarefamanagement.application.ConsultarTarefaController;
import eapli.base.tarefamanagement.application.PesquisarTarefaController;
import eapli.base.tarefamanagement.application.ReivindicarTarefaController;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;

public class ReivindicarTarefaUI extends AbstractUI {

    private final ReivindicarTarefaController controller=new ReivindicarTarefaController();
    private final PesquisarTarefaController controllerTar=new PesquisarTarefaController();
    private final ConsultarTarefaController controllerTarefas=new ConsultarTarefaController();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ColaboradorComUserController colaboradorComUserController=new ColaboradorComUserController();
    private final ListarColaboradoresController controllercol=new ListarColaboradoresController();
    private final PesquisarColaboradorController controllerpesqcol=new PesquisarColaboradorController();

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

            while(controllerpesqcol.procurarColaboradorPorNumero(numero)==null)
                numero=Console.readInteger("Titulo colaborador pretendido: ");
        }



        Iterable<InfoTarefa> tarefas=new ArrayList<>();
        try{
            tarefas = controllerTarefas.listarTarefasPendentes(numero);
        }catch (Exception e) {
            e.printStackTrace();
            return true;
        }

        if(tarefas!=null)
            System.out.println("\nTarefas possiveis:\n");
        else
            System.out.println("Ainda não existem tarefas");

        for(InfoTarefa it : tarefas){
            System.out.println("Id: " + it.obterId() + ", Descrição: " + it.obterTarefa().obterDescricao());
        }


        int option=Console.readInteger("\nDeseja reivindicar alguma tarefa?\n0-Não\n1-Sim: ");

        while(option!=0 && option!=1)
            option=Console.readInteger("\nDeseja reivindicar alguma tarefa?\n0-Não\n1-Sim: ");

        if(option==1) {
            int id = Console.readInteger("\nId pretendido: ");

            while (controllerTar.procurarInfoTarefaPorID(id) == null)
                id = Console.readInteger("Id pretendido: ");


            try {
                controller.reivindicarTarefaPendente(id, numero);
                System.out.println("Reivindicado com sucesso");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    @Override
    public String headline() {
        return "Reivindicar Tarefa";
    }

}
