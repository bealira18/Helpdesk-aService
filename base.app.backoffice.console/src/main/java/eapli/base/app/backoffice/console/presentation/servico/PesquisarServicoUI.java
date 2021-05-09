package eapli.base.app.backoffice.console.presentation.servico;

import eapli.base.servicomanagement.application.ListarServicosController;
import eapli.base.servicomanagement.application.PesquisarServicoController;
import eapli.base.servicomanagement.domain.Servico;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class PesquisarServicoUI extends AbstractUI {

    private final PesquisarServicoController controller=new PesquisarServicoController();
    private final ListarServicosController controlleraux=new ListarServicosController();

    @Override
    protected boolean doShow(){

        try {
            Iterable<Servico> servicos = controlleraux.listarServicos();

            for (Servico s : servicos) {
                if (s.estaAtivo() && s.estaCompleto()) {
                    System.out.println(s.obterTitulo());
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        String titulo= Console.readLine("Titulo pretendido: ");

        while(controller.procurarServicoPorTitulo(titulo)==null)
            titulo= Console.readLine("Acronimo pretendido: ");

        try{
            Servico s=controller.procurarServicoPorTitulo(titulo);
            System.out.println(s.toString());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public String headline() {
        return "Procurar Serviço";
    }

}
