package eapli.base.app.backoffice.console.presentation.tarefa;

import eapli.base.colaboradormanagement.application.ListarColaboradoresController;
import eapli.base.colaboradormanagement.application.PesquisarColaboradorController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.application.AssociarColaboradorAEquipaController;
import eapli.base.equipamanagement.application.ListarEquipasController;
import eapli.base.equipamanagement.application.PesquisarEquipaController;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.tarefamanagement.application.ConsultarTarefaController;
import eapli.base.tarefamanagement.application.PesquisarTarefaController;
import eapli.base.tarefamanagement.application.ReivindicarTarefaController;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class ReivindicarTarefaUI extends AbstractUI {

    private final ReivindicarTarefaController controller=new ReivindicarTarefaController();
    private final ListarColaboradoresController controllerColab=new ListarColaboradoresController();
    private final PesquisarColaboradorController controllerPesqColab=new PesquisarColaboradorController();
    private final PesquisarTarefaController controllerTar=new PesquisarTarefaController();
    private final ConsultarTarefaController controllerTarefas=new ConsultarTarefaController();

    @Override
    protected boolean doShow(){

        final Iterable<Colaborador> colaboradores=controllerColab.listarColaboradores();

        if(colaboradores!=null)
            System.out.println("Colaboradores possiveis:\n");
        else
            System.out.println("Ainda não existem colaboradores");

        for(Colaborador c : colaboradores){
            System.out.println(c.toString());
        }

        final Iterable<TarefaManual> tarefas=controllerTarefas.listarTarefasPendentes();

        if(tarefas!=null)
            System.out.println("\nTarefas possiveis:\n");
        else
            System.out.println("Ainda não existem equipas");

        for(TarefaManual tm : tarefas){
            System.out.println(tm.toString());
        }

        int num= Console.readInteger("\nNumero pretendido: ");

        while(controllerPesqColab.procurarColaboradorPorNumero(num)==null)
            num= Console.readInteger("Numero pretendido: ");

        int id= Console.readInteger("\nId pretendido: ");

        while(controllerTar.procurarTarefaPorID(id)==null)
            id= Console.readInteger("Id pretendido: ");



        try{
            controller.reivindicarTarefaPendente(id,num);
            System.out.println("Reivindicado com sucesso");
        }catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public String headline() {
        return "Reivindicar Tarefa";
    }

}
