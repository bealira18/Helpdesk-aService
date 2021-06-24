package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.servicomanagement.application.AdicionarServicoController;
import eapli.base.servicomanagement.application.AtivarServicoController;
import eapli.framework.actions.Action;

public class ServicoBootstrapper implements Action {

    private final AdicionarServicoController controller = new AdicionarServicoController();
    private final AtivarServicoController ativarServicoController=new AtivarServicoController();

    @Override
    public boolean execute() {

        controller.adicionarServico("cod1","Ausencias", "Ausencias futuras", "Pedido de Ausência Futura", "ausencia", "ausencia.jpg");
        controller.adicionarServico("cod2","Autorizacoes", "Autorizacao Desconto", "Autorização para Aplicação de Desconto", "desconto", "desconto.png");
        controller.adicionarServico("cod3","Alteracoes", "Alteracao Residencia", "Comunicação de Alteração de Residência", "alteracao", "alteracao.png");
        //controller.adicionarServico("cod4","Cotacoes", "Cotacao para venda", "Requerer cotação para venda por grosso", "venda", "venda.png");

        ativarServicoController.ativarServico("cod1");
        ativarServicoController.ativarServico("cod3");

        return true;
    }

}
