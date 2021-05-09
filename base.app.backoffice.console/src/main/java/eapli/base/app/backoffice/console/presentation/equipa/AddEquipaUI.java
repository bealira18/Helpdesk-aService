package eapli.base.app.backoffice.console.presentation.equipa;

import eapli.base.equipamanagement.application.CriarEquipaController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class AddEquipaUI extends AbstractUI {

    private final CriarEquipaController controller=new CriarEquipaController();

    @Override
    protected boolean doShow(){

        final String acronimo= Console.readLine("Acronimo: ");
        final String designacao=Console.readLine("Designacao: ");

        try{
            this.controller.criarEquipa(acronimo,designacao);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }

    @Override
    public String headline() {
        return "Adicionar Equipa";
    }

}
