package eapli.base.app.backoffice.console.presentation.servico;

import eapli.base.formulariomanagement.application.*;
import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.servicomanagement.application.*;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.tarefamanagement.application.PesquisarTarefaIdController;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class ContinuarServicoUI extends AbstractUI {

    private final ListarServicosController controller=new ListarServicosController();
    private final PesquisarServicoController controllerpesq=new PesquisarServicoController();
    private final EditarServicoController controllereditar=new EditarServicoController();
    private final EditarFormularioController controllerEditF=new EditarFormularioController();
    private final AdicionarAtributoController controllerAddAtr=new AdicionarAtributoController();
    private final AssociarAtributoAFormularioController controllerAssAtrForm=new AssociarAtributoAFormularioController();
    private final ListarAtributosDeFormularioController controllerListAtr=new ListarAtributosDeFormularioController();
    private final EditarAtributoController controllerEditAtr=new EditarAtributoController();
    private final ListarTarefasManuaisWorkflowController controllerListTW=new ListarTarefasManuaisWorkflowController();
    private final AtivarWorkflowController ativarWorkflowController=new AtivarWorkflowController();
    private final PesquisarTarefaIdController pesquisarTarefaIdController=new PesquisarTarefaIdController();

    @Override
    protected boolean doShow(){

        Iterable<Servico> servicosInacabados=controller.listarServicosIncompletos();

        for(Servico s : servicosInacabados){
            System.out.println(s.obterCod()+"\n");
        }

        String cod= Console.readLine("\nCodigo serviço pretendido: ");

        while(controllerpesq.procurarPorCod(cod)==null)
            cod=Console.readLine("Codigo serviço pretendido: ");

        Servico servico=controllerpesq.procurarPorCod(cod);

        String titulo;
        String descricaobreve;
        String descricaocompleta;
        String palavraschave;
        String icone;
        String nomeForm;

        if(servico.obterTitulo().isEmpty()) {
            titulo = Console.readLine("\nTitulo: ");
            controllereditar.mudarDescricaoBreve(cod,titulo);
        }

        if(servico.obterDescricaoBreve().isEmpty()) {
            descricaobreve = Console.readLine("\nDescricao Breve: ");
            controllereditar.mudarDescricaoBreve(cod,descricaobreve);
        }

        if(servico.obterDescricaoCompleta().isEmpty()) {
            descricaocompleta = Console.readLine("\nDescricao Completa: ");
            controllereditar.mudarDescricaoCompleta(cod,descricaocompleta);
        }

        if(servico.obterPalavrasChave().isEmpty()) {
            palavraschave = Console.readLine("\nPalavras chave: ");
            controllereditar.mudarPalavrasChave(cod,palavraschave);
        }

        if(servico.obterIcone().obterIcone().isEmpty()) {
            icone = Console.readLine("\nIcone em jpg ou png: ");
            controllereditar.mudarIcone(cod,icone);
        }

        if(servico.obterFormulario().obterNome().isEmpty()){
            nomeForm=Console.readLine("\nNome Formulario: ");
            controllerEditF.mudarNomeId(servico.obterFormulario().obterId(),nomeForm);
        }

        //se não houver nenhum atributo
        if(servico.obterFormulario().obterAtributos().isEmpty()){

            int aux=Console.readInteger("O formulario não tem atributos, adicionar?\n0-não\n1-sim");
            while(aux==1) {
                Atributo a=completarFormSemAtributos();
                controllerAssAtrForm.associarAtributoAFormularioIds(servico.obterFormulario().obterId(),a.obterId());
                aux=Console.readInteger("Adicionar mais atributos ao formulario?\n0-não\n1-sim");
            }

        }else{
            if(!servico.obterFormulario().estaAtivo())
                completarFormComAtributos(servico.obterFormulario());
        }

        List<TarefaManual> tarefas=controllerListTW.tarefas(servico.obterWorkflow());

        if(tarefas==null)
            ativarWorkflowController.ativarWorkflow(servico.obterWorkflow());

        System.out.println("Tarefas manuais:\n");
        for(TarefaManual t : tarefas){
            System.out.println(t.toString());
        }

        int id = Console.readInteger("\nId da Tarefa: ");

        while(pesquisarTarefaIdController.procurarTarefaPorId(id)==null)
            id = Console.readInteger("\nId da Tarefa: ");

        TarefaManual t= (TarefaManual) pesquisarTarefaIdController.procurarTarefaPorId(id);

        if(t.obterFormulario().obterAtributos().isEmpty()){

            int aux=Console.readInteger("O formulario não tem atributos, adicionar?\n0-não\n1-sim");
            while(aux==1) {
                Atributo a=completarFormSemAtributos();
                controllerAssAtrForm.associarAtributoAFormularioIds(servico.obterFormulario().obterId(),a.obterId());
                aux=Console.readInteger("Adicionar mais atributos ao formulario?\n0-não\n1-sim");
            }

        }else{
            if(!t.obterFormulario().estaAtivo())
                completarFormComAtributos(t.obterFormulario());
        }

        if(ativarWorkflowController.verificarServico(servico))
            System.out.println("Ativado com sucesso!\n");

        return true;
    }

    public Atributo completarFormSemAtributos(){

        final String nomeAtributo = Console.readLine("Nome Atributo: ");
        final String etiqueta = Console.readLine("Etiqueta: ");
        final String descricao = Console.readLine("Descricao: ");
        final String expressao = Console.readLine("Expressao Regular: ");
        final String tipoDadosBase = Console.readLine("Tipo Dados Base: ");

        Atributo a = new Atributo();

        try {
            a = controllerAddAtr.adicionarAtributo(nomeAtributo, etiqueta, descricao, expressao, tipoDadosBase);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    public void completarFormComAtributos(Formulario formulario){

        //se já tiver atributos
        //mostrar lista com nome dos atributos
        //escolher um e editar

        List<Atributo> atributos=controllerListAtr.listarAtributosIncompletosFormulario(formulario.obterId());

        System.out.println("Atributos existentes no formulario correspondente ao serviço que está a ser editado:\n");

        for(Atributo a : atributos){
            System.out.println(a.obterNome());
        }

        String nomeF=Console.readLine("Atributo a editar/completar:\n");

        while(controllerListAtr.procurarAtributoPorNome(formulario.obterId(),nomeF)==null){
            nomeF=Console.readLine("Atributo a editar/completar:\n");
        }

        Atributo a=controllerListAtr.procurarAtributoPorNome(formulario.obterId(),nomeF);

        if(a.obterEtiqueta().isEmpty()) {
            String etiqueta = Console.readLine("\nEtiqueta: ");
            controllerEditAtr.mudarEtiqueta(nomeF,etiqueta);
        }

        if(a.obterDescricao().isEmpty()) {
            String descricao = Console.readLine("\nDescricao: ");
            controllerEditAtr.mudarDescricao(nomeF,descricao);
        }

        if(a.obterExpressaoRegular().obterExpressaoRegular().isEmpty()) {
            String expressao = Console.readLine("\nExpressao Regular: ");
            controllerEditAtr.mudarExpressaoRegular(nomeF,expressao);
        }

        if(a.obterTipoDadosBase().obterTipoDadosBase().isEmpty()) {
            String dados = Console.readLine("\nTipo Dados Base: ");
            controllerEditAtr.mudarTipoDadosBase(nomeF,dados);
        }

    }

    @Override
    public String headline() {
        return "Acabar serviço incompleto";
    }

}
