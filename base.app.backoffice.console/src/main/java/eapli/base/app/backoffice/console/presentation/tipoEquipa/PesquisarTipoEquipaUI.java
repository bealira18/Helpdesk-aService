package eapli.base.app.backoffice.console.presentation.tipoEquipa;

import eapli.base.equipamanagement.application.ListarTiposEquipaController;
import eapli.base.equipamanagement.application.PesquisarTipoEquipaController;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.equipamanagement.domain.TipoEquipa;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class PesquisarTipoEquipaUI extends AbstractUI {

    private final PesquisarTipoEquipaController controller=new PesquisarTipoEquipaController();
    private final ListarTiposEquipaController controlleraux=new ListarTiposEquipaController();

    @Override
    protected boolean doShow(){

        try{
            Iterable<TipoEquipa> tiposEquipa=controlleraux.listarTiposEquipa();

            System.out.println("Tipos disponiveis\n");

            for(TipoEquipa t : tiposEquipa){
                System.out.println(t.obterNome()+"\n");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        String nome= Console.readLine("Nome pretendido: ");

        while(controller.procurarTipoEquipaPorNome(nome)==null)
            nome= Console.readLine("Nome pretendido: ");

        try{
            TipoEquipa tipoEquipa=controller.procurarTipoEquipaPorNome(nome);
            System.out.println(tipoEquipa.toString());
        }catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }


    @Override
    public String headline() {
        return "Procurar Tipo de Equipa";
    }

}
