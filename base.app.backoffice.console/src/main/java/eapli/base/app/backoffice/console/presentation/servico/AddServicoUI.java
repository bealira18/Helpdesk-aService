package eapli.base.app.backoffice.console.presentation.servico;

import eapli.base.formulariomanagement.application.AdicionarAtributoController;
import eapli.base.formulariomanagement.application.AdicionarFormularioController;
import eapli.base.formulariomanagement.application.AssociarAtributoAFormularioController;
import eapli.base.formulariomanagement.application.EditarFormularioController;
import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.servicomanagement.application.AdicionarServicoController;
import eapli.base.servicomanagement.application.AdicionarWorkflowController;
import eapli.base.servicomanagement.application.AssociarFormularioAServicoController;
import eapli.base.servicomanagement.application.AssociarWorkflowAServicoController;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.tarefamanagement.application.AssociarTarefaAFormularioController;
import eapli.base.tarefamanagement.application.CriarTarefaAutomaticaController;
import eapli.base.tarefamanagement.application.CriarTarefaManualController;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AddServicoUI extends AbstractUI {

    private final AdicionarServicoController controller=new AdicionarServicoController();
    private final AdicionarFormularioController controllerForm=new AdicionarFormularioController();
    private final AssociarFormularioAServicoController controllerAss=new AssociarFormularioAServicoController();
    private final AdicionarAtributoController controllerAtr=new AdicionarAtributoController();
    private final AssociarAtributoAFormularioController controllerAssAtrForm=new AssociarAtributoAFormularioController();
    private final AdicionarWorkflowController controllerWorkflow=new AdicionarWorkflowController();
    private final CriarTarefaManualController controllerManual=new CriarTarefaManualController();
    private final CriarTarefaAutomaticaController controllerAutomatica=new CriarTarefaAutomaticaController();
    private final AssociarWorkflowAServicoController controllerAssWS=new AssociarWorkflowAServicoController();
    private final AssociarTarefaAFormularioController controllerAssFT=new AssociarTarefaAFormularioController();
    private final EditarFormularioController editarFormularioController=new EditarFormularioController();

    @Override
    protected boolean doShow(){

        final String cod= Console.readLine("Codigo unico: ");
        final String titulo= Console.readLine("Titulo: ");
        final String descricaobreve= Console.readLine("Descricao Breve: ");
        final String descricaocompleta= Console.readLine("Descricao Completa: ");
        final String palavrasChave= Console.readLine("Palavras chave: ");
        final String icone= Console.readLine("Icone: ");

        Servico s=new Servico();

        try{
            s=controller.adicionarServico(cod,titulo,descricaobreve,descricaocompleta,palavrasChave,icone);
        }catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("\nAdicionar formulario ao serviço:\n");

        final String nomeForm = Console.readLine("Nome do Formulario: ");

        Formulario f = new Formulario();

        try {
            f = controllerForm.adicionarFormulario(nomeForm);
        } catch (Exception e) {
            e.printStackTrace();
        }

        controllerAss.associarFormularioAServicoComIdF(f.obterId(), s.obterId());

        addFormulario(f);

        System.out.println("\nDefinir workflow para o serviço\n");

        System.out.println("Adicionar tarefa(s):\n");

        List<Tarefa> tarefas=new ArrayList<>();

        int aux=Console.readInteger("Tarefa de aprovação?\n0-não\n1-sim");

        while(aux!=0 && aux!=1)
            aux = Console.readInteger("Tarefa de aprovação?\n0-não\n1-sim");

        int manual;

        if(aux==1){
            //tem tarefa de aprovação
            manual=Console.readInteger("Tarefa de aprovação é manual?\n0-não\n1-sim");

            while(manual!=0 && manual!=1)
                manual = Console.readInteger("Tarefa de aprovação é manual?\n0-não\n1-sim");

            if(manual==1){
                Tarefa t1=controllerManual.criarTarefaManualWorkflow(true);

                System.out.println("\nAdicionar formulario à tarefa:\n");

                final String nomeFormT = Console.readLine("Nome do Formulario: ");

                Formulario form = new Formulario();

                try {
                    form = controllerForm.adicionarFormulario(nomeFormT);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                addFormulario(form);

                t1=controllerAssFT.associarTarefaAFormularioIds(form.obterId(), t1.obterId());

                tarefas.add(t1);
            }else{
                Tarefa t2=controllerAutomatica.criarTarefaAutomaticaWorkflow(true);
                tarefas.add(t2);
            }
        }

        //tarefa resoluçao

        System.out.println("Tarefa de Resolução");

        manual=Console.readInteger("Tarefa de resolução é manual?\n0-não\n1-sim");

        while(manual!=0 && manual!=1)
            manual = Console.readInteger("Tarefa de resolução é manual?\n0-não\n1-sim");

        if(manual==1){
            Tarefa t3=controllerManual.criarTarefaManualWorkflow(false);

            System.out.println("\nAdicionar formulario à tarefa:\n");

            final String nomeFormT = Console.readLine("Nome do Formulario: ");

            Formulario form = new Formulario();

            try {
                form = controllerForm.adicionarFormulario(nomeFormT);
            } catch (Exception e) {
                e.printStackTrace();
            }

            addFormulario(form);

            t3=controllerAssFT.associarTarefaAFormularioIds(form.obterId(), t3.obterId());

            tarefas.add(t3);
        }else{
            Tarefa t4=controllerAutomatica.criarTarefaAutomaticaWorkflow(false);
            tarefas.add(t4);
        }

        Workflow w=controllerWorkflow.adicionarWorkflow(tarefas);
        controllerAssWS.associarWorkflowAServico(w.obterId(),s.obterCod());

        System.out.println("\nServiço adicionado com sucesso!");

        return true;

    }

    public void addFormulario(Formulario f){

        int numAtributos=0;

        int aux = Console.readInteger("Adicionar atributos ao formulario?\n0-não\n1-sim");

        while(aux!=0 && aux!=1)
            aux = Console.readInteger("Adicionar atributos ao formulario?\n0-não\n1-sim");

        while (aux == 1) {
            //tornar nome obrigatorio
            final String nomeAtributo = Console.readLine("Nome Atributo: ");
            final String etiqueta = Console.readLine("Etiqueta: ");
            final String descricao = Console.readLine("Descricao: ");
            final String expressao = Console.readLine("Expressao Regular: ");
            final String tipoDadosBase = Console.readLine("Tipo Dados Base: ");

            Atributo a = new Atributo();

            try {
                a = controllerAtr.adicionarAtributo(nomeAtributo, etiqueta, descricao, expressao, tipoDadosBase);
                numAtributos++;
            } catch (Exception e) {
                e.printStackTrace();
            }

            controllerAssAtrForm.associarAtributoAFormularioIds(f.obterId(), a.obterId());

            editarFormularioController.mudarNumAtributos(f.obterNome(),numAtributos);

            aux = Console.readInteger("Adicionar mais atributos ao formulario?\n0-não\n1-sim");

            while(aux!=0 && aux!=1)
                aux = Console.readInteger("Adicionar mais atributos ao formulario?\n0-não\n1-sim");

        }

    }

    @Override
    public String headline() {
        return "Adicionar Serviço";
    }

}
