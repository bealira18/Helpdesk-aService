package eapli.base.app.backoffice.console.presentation.servico;

import eapli.base.servicomanagement.application.ListarServicosController;
import eapli.base.servicomanagement.domain.Servico;
import eapli.framework.presentation.console.AbstractUI;

public class ListarServicoUI extends AbstractUI {

    private final ListarServicosController controller=new ListarServicosController();

    @Override
    protected boolean doShow(){

        try {
            Iterable<Servico> servicos = controller.listarServicos();

            for (Servico s : servicos) {
                if (s.estaAtivo() && s.estaCompleto()) {
                    System.out.println(s.toString());
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public String headline() {
        return "Listar serviços ativos";
    }

}
