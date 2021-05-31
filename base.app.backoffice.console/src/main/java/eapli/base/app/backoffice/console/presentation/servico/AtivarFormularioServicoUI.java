package eapli.base.app.backoffice.console.presentation.servico;

import eapli.base.formulariomanagement.application.AtivarFormularioController;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.servicomanagement.application.AtivarWorkflowController;
import eapli.base.servicomanagement.application.ListarServicosController;
import eapli.base.servicomanagement.application.ListarTarefasManuaisWorkflowController;
import eapli.base.servicomanagement.application.PesquisarServicoController;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.tarefamanagement.application.PesquisarTarefaIdController;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.hibernate.mapping.Formula;

public class AtivarFormularioServicoUI extends AbstractUI {

    private final ListarServicosController controllerList=new ListarServicosController();
    private final PesquisarServicoController controllerPesq=new PesquisarServicoController();
    private final AtivarFormularioController controller=new AtivarFormularioController();
    private final ListarTarefasManuaisWorkflowController listarTarefasManuaisWorkflowController=new ListarTarefasManuaisWorkflowController();
    private final PesquisarTarefaIdController pesquisarTarefaIdController=new PesquisarTarefaIdController();
    private final AtivarWorkflowController ativarWorkflowController=new AtivarWorkflowController();

    @Override
    protected boolean doShow(){

        System.out.println("Escolher o serviço para ativar o formulario\n");

        try {
            Iterable<Servico> servicos = controllerList.listarServicos();

            for (Servico s : servicos) {
                System.out.println(s.obterCod());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String cod = Console.readLine("\nCodigo pretendido: ");

        while (controllerPesq.procurarServicoPorCod(cod) == null)
            cod = Console.readLine("Codigo pretendido: ");

        Servico s = new Servico();

        try {
            s = controllerPesq.procurarServicoPorCod(cod);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Formulario f=new Formulario();

        try {
            f=controller.ativarFormServico(s.obterFormulario().obterNome(), s);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!f.estaAtivo())
            System.out.println("Não pode ser ativado");
        else
            System.out.println("Ativado com sucesso!");



        int aux= Console.readInteger("Ativar formulario de tarefa=\n0-Não\n1-Sim");

        while(aux!=0 && aux!=1)
            aux= Console.readInteger("Ativar formulario de tarefa=\n0-Não\n1-Sim");

        if(aux==1){
            try {
                Iterable<TarefaManual> tarefas = listarTarefasManuaisWorkflowController.tarefas(s.obterWorkflow());

                for (Tarefa t : tarefas) {
                    System.out.println("Id tarefa: " + t.obterId() + ", Descricao: " + t.obterDescricao());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            int id = Console.readInteger("\nId pretendido: ");

            while (pesquisarTarefaIdController.procurarTarefaPorId(id) == null)
                id = Console.readInteger("Id pretendido: ");

            TarefaManual t = new TarefaManual();

            try {
                t = (TarefaManual) pesquisarTarefaIdController.procurarTarefaPorId(id);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Workflow w =new Workflow();

            try {
                w=ativarWorkflowController.ativarTarefaWorkflow(t.obterFormulario().obterId(),s);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (!w.estaCompleto())
                System.out.println("Não pode ser ativado");
            else
                System.out.println("Ativado com sucesso!");
        }

        if(ativarWorkflowController.verificarServico(s))
            System.out.println("\nO serviço também foi ativado uma vez que os formularios também estão ativos\n");

        return true;
    }

    @Override
    public String headline() {
        return "Ativar Formulario";
    }

}
