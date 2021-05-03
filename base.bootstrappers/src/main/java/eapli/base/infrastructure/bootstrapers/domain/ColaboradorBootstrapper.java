package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.colaboradormanagement.application.AdicionarColaboradorController;
import eapli.framework.actions.Action;

import java.util.Date;

public class ColaboradorBootstrapper implements Action {

    private final AdicionarColaboradorController controller=new AdicionarColaboradorController();

    @Override
    public boolean execute() {

        controller.adicionarColaborador(36,"Bea","Beatriz Lira",new Date(2001/05/18),"Gaia",true,"ui@gmail.com","idk","idk",919191991L);
        controller.adicionarColaborador(8,"Pedro","Pedro Morais",new Date(1998/11/25),"Matosinhos",true,"ai@isep.ipp.pt","idk","idk",939393939L);

        return true;
    }

}


