package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.servicomanagement.application.AdicionarServicoController;
import eapli.framework.actions.Action;

public class ServicoBootstrapper implements Action {

    private final AdicionarServicoController controller = new AdicionarServicoController();

    @Override
    public boolean execute() {

        controller.adicionarServico("Título", "Tít", "TítuloExemplo", "exemplo, titulo", "tituloExemplo.jpg");
        controller.adicionarServico("Exemplo", "Ex", "ExemploTítulo", "título, exemplo", "exemploTitulo.png");

        return true;
    }

}
