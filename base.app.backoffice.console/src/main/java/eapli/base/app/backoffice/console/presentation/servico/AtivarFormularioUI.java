package eapli.base.app.backoffice.console.presentation.servico;

import eapli.base.formulariomanagement.application.AtivarFormularioController;
import eapli.base.servicomanagement.application.ListarServicosController;
import eapli.base.servicomanagement.application.PesquisarServicoController;
import eapli.base.servicomanagement.domain.Servico;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class AtivarFormularioUI extends AbstractUI {

    private final ListarServicosController controllerList=new ListarServicosController();
    private final PesquisarServicoController controllerPesq=new PesquisarServicoController();
    private final AtivarFormularioController controller=new AtivarFormularioController();

    @Override
    protected boolean doShow(){

        try {
            Iterable<Servico> servicos = controllerList.listarServicos();

            for (Servico s : servicos) {
                    System.out.println(s.obterTitulo());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        String titulo= Console.readLine("\nTitulo pretendido: ");

        while(controllerPesq.procurarServicoPorTitulo(titulo)==null)
            titulo= Console.readLine("Acronimo pretendido: ");

        Servico s=new Servico();

        try{
            s=controllerPesq.procurarServicoPorTitulo(titulo);
        }catch (Exception e) {
            e.printStackTrace();
        }

        try{
            controller.ativar(s.obterFormulario().obterNome(),s);
        }catch (Exception e) {
            e.printStackTrace();
        }

        if(!s.obterFormulario().estaAtivo())
            System.out.println("Não pode ser ativado");
        else
            System.out.println("Ativado com sucesso!");

        return true;
    }

    @Override
    public String headline() {
        return "Ativar Formulario";
    }

}
