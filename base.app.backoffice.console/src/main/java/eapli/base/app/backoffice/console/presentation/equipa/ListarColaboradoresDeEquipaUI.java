package eapli.base.app.backoffice.console.presentation.equipa;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.application.ListarColaboradoresEquipaController;
import eapli.base.equipamanagement.application.ListarEquipasController;
import eapli.base.equipamanagement.application.PesquisarEquipaController;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class ListarColaboradoresDeEquipaUI extends AbstractUI {

    private final ListarColaboradoresEquipaController controller=new ListarColaboradoresEquipaController();
    private final ListarEquipasController controllerlisteq=new ListarEquipasController();
    private final PesquisarEquipaController controllerpesqeq=new PesquisarEquipaController();

    @Override
    protected boolean doShow(){

        //listar equipas

        Iterable<Equipa> equipas=controllerlisteq.listarEquipas();

        for(Equipa e : equipas){
            System.out.println(e.acronimo()+"\n");
        }

        //escolher equipa

        String acronimo= Console.readLine("\nAcronimo pretendido: ");

        while(controllerpesqeq.procurarEquipaPorAcronimo(acronimo)==null)
            acronimo=Console.readLine("Acronimo pretendido: ");


        try{
            List<Colaborador> colaboradores=controller.listarColaboradoresEquipa(acronimo);

            for(Colaborador c :colaboradores){
                System.out.println(c.toString()+"\n");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }

    @Override
    public String headline() {
        return "Listar Colaboradores de uma equipa";
    }

}
