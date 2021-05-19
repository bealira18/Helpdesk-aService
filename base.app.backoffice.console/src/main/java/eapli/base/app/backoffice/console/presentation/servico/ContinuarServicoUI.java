package eapli.base.app.backoffice.console.presentation.servico;

import eapli.base.formulariomanagement.application.*;
import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.servicomanagement.application.EditarServicoController;
import eapli.base.servicomanagement.application.ListarServicosController;
import eapli.base.servicomanagement.application.PesquisarServicoController;
import eapli.base.servicomanagement.domain.Servico;
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

    @Override
    protected boolean doShow(){

        Iterable<Servico> servicosInacabados=controller.listarServicosIncompletos();

        for(Servico s : servicosInacabados){
            System.out.println(s.obterTitulo()+"\n");
        }

        String titulo= Console.readLine("\nTitulo serviço pretendido: ");

        while(controllerpesq.procurarServicoPorTitulo(titulo)==null)
            titulo=Console.readLine("Titulo serviço pretendido: ");

        Servico servico=controllerpesq.procurarServicoPorTitulo(titulo);

        String descricaobreve;
        String descricaocompleta;
        String palavraschave;
        String icone;
        String nomeForm;

        if(servico.obterDescricaoBreve().isEmpty()) {
            descricaobreve = Console.readLine("\nDescricao Breve: ");
            controllereditar.mudarDescricaoBreve(titulo,descricaobreve);
        }

        if(servico.obterDescricaoCompleta().isEmpty()) {
            descricaocompleta = Console.readLine("\nDescricao Completa: ");
            controllereditar.mudarDescricaoCompleta(titulo,descricaocompleta);
        }

        if(servico.obterPalavrasChave().isEmpty()) {
            palavraschave = Console.readLine("\nPalavras chave: ");
            controllereditar.mudarPalavrasChave(titulo,palavraschave);
        }

        if(servico.obterIcone().obterIcone().isEmpty()) {
            icone = Console.readLine("\nIcone em jpg ou png: ");
            controllereditar.mudarIcone(titulo,icone);
        }

        if(servico.obterFormulario().obterNome().isEmpty()){
            nomeForm=Console.readLine("\nNome Formulario: ");
            controllerEditF.mudarNomeId(servico.obterFormulario().obterId(),nomeForm);
        }

        //se não houver nenhum atributo
        if(servico.obterFormulario().obterAtributos().isEmpty()){

            int aux=Console.readInteger("O formulario não tem atributos, adicionar?\n0-não\n1-sim");

            while(aux==1) {

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

                controllerAssAtrForm.associarAtributoAFormularioIds(servico.obterFormulario().obterId(),a.obterId());

                aux=Console.readInteger("Adicionar mais atributos ao formulario?\n0-não\n1-sim");
            }
        }else{
            //se já tiver atributos
            //mostrar lista com nome dos atributos
            //escolher um e editar

            List<Atributo> atributos=controllerListAtr.listarAtributosIncompletosFormulario(servico.obterFormulario().obterId());

            System.out.println("Atributos existentes no formulario correspondente ao serviço que está a ser editado:\n");

            for(Atributo a : atributos){
                System.out.println(a.obterNome());
            }

            String nomeF=Console.readLine("Atributo a editar/completar:\n");

            while(controllerListAtr.procurarAtributoPorNome(servico.obterFormulario().obterId(),nomeF)==null){
                nomeF=Console.readLine("Atributo a editar/completar:\n");
            }

            Atributo a=controllerListAtr.procurarAtributoPorNome(servico.obterFormulario().obterId(),nomeF);

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


        return true;
    }

    @Override
    public String headline() {
        return "Acabar serviço incompleto";
    }

}
