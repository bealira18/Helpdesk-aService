package eapli.base.app.backoffice.console.presentation.equipa;

import eapli.base.equipamanagement.application.*;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.equipamanagement.domain.TipoEquipa;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class AssociarTipoEquipaAEquipaUI extends AbstractUI {

    private final AssociarTipoEquipaAEquipaController controller=new AssociarTipoEquipaAEquipaController();
    private final ListarTiposEquipaController controllerTE=new ListarTiposEquipaController();
    private final ListarEquipasController controllerE=new ListarEquipasController();
    private final PesquisarEquipaController controllerPesqE=new PesquisarEquipaController();
    private final PesquisarTipoEquipaController controllerPesqTE=new PesquisarTipoEquipaController();

    @Override
    protected boolean doShow(){

        Iterable<Equipa> equipas= controllerE.listarEquipas();

        if(equipas!=null)
            System.out.println("Equipas possiveis:\n");
        else
            System.out.println("Ainda não existem equipas");

        for(Equipa e : equipas){
            System.out.println(e.toString());
            System.out.println();
        }

        Iterable<TipoEquipa> tipoequipas= controllerTE.listarTiposEquipa();

        if(tipoequipas!=null)
            System.out.println("\nTipo equipas possiveis:\n");
        else
            System.out.println("Ainda não existem tipo de equipas");

        for(TipoEquipa t : tipoequipas){
            System.out.println(t.toString());
            System.out.println();
        }

        String acronimoEquipa= Console.readLine("\nAcronimo pretendido: ");

        while(controllerPesqE.procurarEquipaPorAcronimo(acronimoEquipa)==null)
            acronimoEquipa=Console.readLine("Acronimo pretendido: ");

        String nomeTipoEquipa= Console.readLine("\nNome tipo equipa pretendido: ");

        while(controllerPesqTE.procurarTipoEquipaPorNome(nomeTipoEquipa)==null)
            nomeTipoEquipa=Console.readLine("Acronimo pretendido: ");

        try{
            controller.associarTipoEquipaAEquipa(acronimoEquipa,nomeTipoEquipa);
            System.out.println("Associado com sucesso");
        }catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }


    @Override
    public String headline() {
        return "Associar tipo de equipa a equipa";
    }

}
