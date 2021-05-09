package eapli.base.app.backoffice.console.presentation.equipa;

import eapli.base.equipamanagement.application.ListarEquipasController;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.framework.presentation.console.AbstractUI;

public class ListarEquipaUI extends AbstractUI {

    private final ListarEquipasController controller=new ListarEquipasController();

    @Override
    protected boolean doShow(){
        try{
            Iterable<Equipa> equipas=controller.listarEquipas();

            for(Equipa e :equipas){
                System.out.println(e.toString()+"\n");
            }

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
