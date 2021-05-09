package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.base.colaboradormanagement.application.ListarColaboradoresController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.framework.presentation.console.AbstractUI;

public class ListarColaboradorUI extends AbstractUI {

    private final ListarColaboradoresController controller=new ListarColaboradoresController();

    @Override
    protected boolean doShow(){
        try {
            Iterable<Colaborador> colaboradores = controller.listarColaboradores();

            for (Colaborador c : colaboradores) {
                System.out.println(c.toString()+"\n");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public String headline() {
        return "Listar Colaboradores";
    }

}
