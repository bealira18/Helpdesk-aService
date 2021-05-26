package eapli.base.app.backoffice.console.presentation.tarefa;

import eapli.base.tarefamanagement.application.ConsultarTarefaController;
import eapli.base.tarefamanagement.application.CriarTarefaManualController;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.Date;

public class CriarTarefaUI extends AbstractUI {


    private final CriarTarefaManualController controller=new CriarTarefaManualController();
    private final ConsultarTarefaController cosultacontroller=new ConsultarTarefaController();

    @Override
    protected boolean doShow(){

        final Iterable<TarefaManual> tarefasPendentes=cosultacontroller.listarTarefasPendentes();

        if(tarefasPendentes!=null)
            System.out.println("Tarefas Manuais indisponiveis:\n");

        for(TarefaManual n : tarefasPendentes){
            System.out.println(n.toString());
        }

        /*final Date dataLimite=Console.readDate("Data Limite (yyyy/mm/dd): ");
        int tempo=Console.readInteger("Tempo: ");
        int prioridade=Console.readInteger("Prioridade (0-5): ");

        try {
            this.controller.criarTarefaManual(dataLimite,tempo,prioridade);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        return true;

    }

    @Override
    public String headline() {
        return "Criar Tarefa Manual";
    }

}
