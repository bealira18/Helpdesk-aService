package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.colaboradormanagement.application.AdicionarColaboradorController;
import eapli.base.colaboradormanagement.application.EditarColaboradorController;
import eapli.framework.actions.Action;

import java.util.Date;

public class ColaboradorBootstrapper implements Action {

    private final AdicionarColaboradorController controller = new AdicionarColaboradorController();
    //private final EditarColaboradorController editarController = new EditarColaboradorController();

    @Override
    public boolean execute() {

        controller.adicionarColaborador(36, "Bea", "Beatriz Lira", new Date(2001 / 05 / 18), "Gaia", true, "bea@gmail.com", "colaborador", "colaborador", "919191991");
        controller.adicionarColaborador(8, "Pedro", "Pedro Morais", new Date(1998 / 11 / 25), "Matosinhos", true, "pedro@isep.ipp.pt", "colaborador", "colaborador", "939393939");
        controller.adicionarColaborador(5, "Joao", "Joao Moreira", new Date(2000 / 05 / 23), "Porto", true, "jm@isep.ipp.pt", "colaborador", "colaborador", "939393939");

        //editarController.mudarNomeCurto("Bea", "Beazita");
        //editarController.mudarNomeCompleto("Beatriz Lira", "Beatriz Meireles");
        //editarController.mudarLocalResidencia("Pedro Morais", "Rua das Bananas");
        //editarController.mudarPasse("Pedro Morais", "naovaisdescobrirahah");
        //editarController.mudarEmail("Pedro Morais", "pedritopontocome@hotmail.com");
        //editarController.mudarFuncao("Pedro Morais", "chefe");
        //editarController.mudarContacto("Pedro Morais", 912345678);
        
        return true;
    }

}
