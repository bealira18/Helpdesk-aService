package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.colaboradormanagement.application.AdicionarColaboradorController;
import eapli.base.colaboradormanagement.application.EditarColaboradorController;
import eapli.framework.actions.Action;

import java.util.Date;

public class ColaboradorBootstrapper implements Action {

    private final AdicionarColaboradorController controller = new AdicionarColaboradorController();

    @Override
    public boolean execute() {

        controller.adicionarColaborador(36, "Bea", "Beatriz Lira", new Date(2001 / 05 / 18), "Gaia", true, "bea@gmail.com", "colaborador", "colaborador", "919191991");
        controller.adicionarColaborador(8, "Pedro", "Pedro Morais", new Date(1998 / 11 / 25), "Matosinhos", true, "pedro@isep.ipp.pt", "colaborador", "colaborador", "939393939");
        controller.adicionarColaborador(5, "Joao", "Joao Moreira", new Date(2000 / 05 / 23), "Porto", true, "jm@isep.ipp.pt", "colaborador", "colaborador", "939393939");

        return true;
    }

}
