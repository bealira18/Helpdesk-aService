package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.base.colaboradormanagement.application.ListarColaboradoresController;
import eapli.base.colaboradormanagement.application.PesquisarColaboradorController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.application.AssociarColaboradorAEquipaController;
import eapli.base.equipamanagement.application.ListarEquipasController;
import eapli.base.equipamanagement.application.PesquisarEquipaController;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class AssociarColaboradorAEquipaUI extends AbstractUI {

    private final AssociarColaboradorAEquipaController controller=new AssociarColaboradorAEquipaController();
    private final ListarColaboradoresController controllerColab=new ListarColaboradoresController();
    private final ListarEquipasController controllerEq=new ListarEquipasController();
    private final PesquisarColaboradorController controllerPesqColab=new PesquisarColaboradorController();
    private final PesquisarEquipaController controllerPesqEq=new PesquisarEquipaController();

    @Override
    protected boolean doShow(){

        final Iterable<Colaborador> colaboradores=controllerColab.listarColaboradores();

        if(colaboradores!=null)
            System.out.println("Colaboradores possiveis:\n");
        else
            System.out.println("Ainda não existem colaboradores");

        for(Colaborador c : colaboradores){
            System.out.println(c.toString());
        }

        final Iterable<Equipa> equipas=controllerEq.listarEquipas();

        if(equipas!=null)
            System.out.println("\nEquipas possiveis:\n");
        else
            System.out.println("Ainda não existem equipas");

        for(Equipa e : equipas){
            System.out.println(e.toString());
        }

        int num= Console.readInteger("\nNumero pretendido: ");

        while(controllerPesqColab.procurarColaboradorNumero(num)==null)
            num= Console.readInteger("Numero pretendido: ");

        String acronimo=Console.readLine("Acronimo pretendido: ");

        while(controllerPesqEq.procurarEquipaPorAcronimo(acronimo)==null)
            acronimo=Console.readLine("Acronimo pretendido: ");

        try{
            controller.associarColaboradorAEquipa(acronimo,num);
            System.out.println("Adicionado com sucesso");
        }catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public String headline() {
        return "Associar colaborador a equipa";
    }

}
