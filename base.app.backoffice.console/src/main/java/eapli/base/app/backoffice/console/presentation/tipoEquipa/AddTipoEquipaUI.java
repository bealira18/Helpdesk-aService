package eapli.base.app.backoffice.console.presentation.tipoEquipa;

import eapli.base.equipamanagement.application.AdicionarTipoEquipaController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class AddTipoEquipaUI extends AbstractUI {

    private final AdicionarTipoEquipaController controller=new AdicionarTipoEquipaController();

    @Override
    protected boolean doShow(){

        final String nome= Console.readLine("Nome: ");
        final String descricao=Console.readLine("Descricao: ");
        final String cor=Console.readLine("Cor: ");

        try{
            this.controller.adicionarTipoEquipa(nome,descricao,cor);
            System.out.println("Adicionado com sucesso");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public String headline() {
        return "Adicionar Tipo Equipa";
    }

}
