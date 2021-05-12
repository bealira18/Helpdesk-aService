package eapli.base.app.backoffice.console.presentation.servico;

import eapli.base.servicomanagement.application.AdicionarServicoController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;



public class AddServicoUI extends AbstractUI {

    private final AdicionarServicoController controller=new AdicionarServicoController();

    @Override
    protected boolean doShow(){

        final String titulo= Console.readLine("Titulo: ");
        final String descricaobreve= Console.readLine("Descricao Breve: ");
        final String descricaocompleta= Console.readLine("Descricao Completa: ");
        final String palavrasChave= Console.readLine("Palavras chave: ");
        final String icone= Console.readLine("Icone: ");

        try{
            controller.adicionarServico(titulo,descricaobreve,descricaocompleta,palavrasChave,icone);
        }catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nAdicionado com sucesso!");

        return true;

    }

    @Override
    public String headline() {
        return "Adicionar Serviço";
    }

}
