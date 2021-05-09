package eapli.base.app.backoffice.console.presentation.equipa;

import eapli.base.equipamanagement.application.ListarEquipasController;
import eapli.base.equipamanagement.application.PesquisarEquipaController;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class PesquisarEquipaUI extends AbstractUI {

    private final PesquisarEquipaController controller=new PesquisarEquipaController();
    private final ListarEquipasController controlleraux=new ListarEquipasController();

    @Override
    protected boolean doShow(){

        try{
            Iterable<Equipa> equipas=controlleraux.listarEquipas();

            for(Equipa e :equipas){
                System.out.println(e.acronimo()+"\n");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        String acronimo= Console.readLine("Acronimo pretendido: ");

        while(controller.procurarEquipaPorAcronimo(acronimo)==null)
            acronimo= Console.readLine("Acronimo pretendido: ");

        try{
            Equipa equipa=controller.procurarEquipaPorAcronimo(acronimo);
            System.out.println(equipa.toString());
        }catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public String headline() {
        return "Procurar Equipa";
    }

}
