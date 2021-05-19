package eapli.base.app.backoffice.console.presentation.servico;

import eapli.base.formulariomanagement.application.AdicionarAtributoController;
import eapli.base.formulariomanagement.application.AdicionarFormularioController;
import eapli.base.formulariomanagement.application.AssociarAtributoAFormularioController;
import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.servicomanagement.application.AdicionarServicoController;
import eapli.base.servicomanagement.application.AssociarFormularioAServicoController;
import eapli.base.servicomanagement.domain.Servico;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;



public class AddServicoUI extends AbstractUI {

    private final AdicionarServicoController controller=new AdicionarServicoController();
    private final AdicionarFormularioController controllerForm=new AdicionarFormularioController();
    private final AssociarFormularioAServicoController controllerAss=new AssociarFormularioAServicoController();
    private final AdicionarAtributoController controllerAtr=new AdicionarAtributoController();
    private final AssociarAtributoAFormularioController controllerAssAtrForm=new AssociarAtributoAFormularioController();

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

        final String nomeForm= Console.readLine("Nome do Formulario: ");

        Formulario f = new Formulario();

        try{
            f=controllerForm.adicionarFormulario(nomeForm);
        }catch (Exception e) {
            e.printStackTrace();
        }

        controllerAss.associarFormularioAServicoComIdF(f.obterId(),s.obterId());

        int aux=Console.readInteger("Adicionar atributos ao formulario?\n0-não\n1-sim");

        while(aux==1){
            final String nomeAtributo= Console.readLine("Nome Atributo: ");
            final String etiqueta= Console.readLine("Etiqueta: ");
            final String descricao= Console.readLine("Descricao: ");
            final String expressao= Console.readLine("Expressao Regular: ");
            final String tipoDadosBase= Console.readLine("Tipo Dados Base: ");

            Atributo a=new Atributo();

            try{
                a=controllerAtr.adicionarAtributo(nomeAtributo,etiqueta,descricao,expressao,tipoDadosBase);
            }catch (Exception e) {
                e.printStackTrace();
            }

            controllerAssAtrForm.associarAtributoAFormularioIds(f.obterId(),a.obterId());

            aux=Console.readInteger("Adicionar mais atributos ao formulario?\n0-não\n1-sim");
        }

        System.out.println("\nServiço adicionado com sucesso!");

        return true;

    }

    @Override
    public String headline() {
        return "Adicionar Serviço";
    }

}
