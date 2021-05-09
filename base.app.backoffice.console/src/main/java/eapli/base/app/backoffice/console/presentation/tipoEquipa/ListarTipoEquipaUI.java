package eapli.base.app.backoffice.console.presentation.tipoEquipa;

import eapli.base.equipamanagement.application.ListarTiposEquipaController;
import eapli.base.equipamanagement.domain.TipoEquipa;
import eapli.framework.presentation.console.AbstractUI;

public class ListarTipoEquipaUI extends AbstractUI {

    private final ListarTiposEquipaController controller=new ListarTiposEquipaController();

    @Override
    protected boolean doShow(){
        try{
            Iterable<TipoEquipa> tipoEquipas=controller.listarTiposEquipa();

            for(TipoEquipa t :tipoEquipas){
                System.out.println(t.toString()+"\n");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public String headline() {
        return "Listar Tipos de Equipa";
    }

}
