package eapli.base.app.backoffice.console.presentation.tarefa;

import eapli.base.colaboradormanagement.application.ListarColaboradoresController;
import eapli.base.colaboradormanagement.application.PesquisarColaboradorController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.application.PesquisarEquipaController;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.tarefamanagement.application.ConsultarTarefaController;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class ConsultarTarefaUI extends AbstractUI {

    private final ConsultarTarefaController controller=new ConsultarTarefaController();
    private final PesquisarColaboradorController controllerpesq=new PesquisarColaboradorController();

    @Override
    protected boolean doShow(){


        int num= Console.readInteger("\nColaborador pretendido: ");

        while(controllerpesq.procurarColaboradorPorNumero(num)==null)
            num =Console.readInteger("Colaborador pretendido: ");


        try{
            List<TarefaManual> tarefas=controller.listarMinhasTarefas(num);

            for(TarefaManual t :tarefas){
                System.out.println(t.toString()+"\n");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }

    @Override
    public String headline() {
        return "Listar Tarefas de um Colaborador";
    }

}
