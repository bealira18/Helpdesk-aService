package eapli.base.app.backoffice.console.presentation.tarefa;

import eapli.base.ClientServer.ThreadClient;
import eapli.base.ClientServer.ThreadServer;
import eapli.base.colaboradormanagement.application.ColaboradorComUserController;
import eapli.base.colaboradormanagement.application.ListarColaboradoresController;
import eapli.base.colaboradormanagement.application.PesquisarColaboradorController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.tarefamanagement.application.ConsultarTarefaController;
import eapli.base.tarefamanagement.application.CriarTarefaManualController;
import eapli.base.tarefamanagement.application.ExecutarTarefaManualController;
import eapli.base.tarefamanagement.domain.EstadoTarefa;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.List;

import static java.lang.Thread.sleep;

public class ExecutarTarefaManualUI extends AbstractUI {


    private final CriarTarefaManualController controller=new CriarTarefaManualController();
    private final ConsultarTarefaController cosultacontroller=new ConsultarTarefaController();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ColaboradorComUserController colaboradorComUserController = new ColaboradorComUserController();
    private final ListarColaboradoresController lcc = new ListarColaboradoresController();
    private final PesquisarColaboradorController pcc = new PesquisarColaboradorController();
    private final ExecutarTarefaManualController etmc = new ExecutarTarefaManualController();

    @Override
    protected boolean doShow(){

        int numero = 0;

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.COLABORADOR)) {
            numero=colaboradorComUserController.resultColaborador().obterNumero().obterNumero();
        }else{
            //mostrar colaboradores
            Iterable<Colaborador> colaboradores=lcc.listarColaboradores();

            for(Colaborador c : colaboradores){
                System.out.println(c.obterNumero()+"\n");
            }

            //escolher colaborador

            numero= Console.readInteger("\nNumero pretendido: ");

            while(pcc.procurarColaboradorNumero(numero)==null) {
                numero = Console.readInteger("Titulo colaborador pretendido: ");
            }
        }

        List<InfoTarefa> tarefas = etmc.listarTarefasPendentesDoColaborador(numero);


        for(InfoTarefa it : tarefas){
            if(it.obterEstado()!= EstadoTarefa.TERMINADA)
                System.out.println(it.obterId()+"\n");
        }

        int flag = 0;
        int idTarefa = 0;
        do{
            idTarefa = Console.readInteger("\nId da tarefa pretendida: ");
            for(InfoTarefa it : tarefas){
                if (it.obterId()==idTarefa){
                    flag = 1;
                    break;
                }
            }
        }while(flag==0);

        Pedido pedido = etmc.executarTarefaManual(numero, idTarefa);

        System.out.println("A tarefa com o id "+idTarefa+" foi executada com sucesso!");

        /*ThreadServer t1 = new ThreadServer();
        t1.start();
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ThreadClient t2 = new ThreadClient(2, pedido.obterId());
        t2.start();*/

        return true;
    }

    @Override
    public String headline() {
        return "Executar Tarefa Manual";
    }

}