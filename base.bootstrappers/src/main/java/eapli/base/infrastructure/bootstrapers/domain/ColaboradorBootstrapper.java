package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.colaboradormanagement.application.AdicionarColaboradorController;
import eapli.base.colaboradormanagement.application.EditarColaboradorController;
import eapli.framework.actions.Action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ColaboradorBootstrapper implements Action {

    private final AdicionarColaboradorController controller = new AdicionarColaboradorController();

    @Override
    public boolean execute() {

        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = new Date();
        Date date2 = new Date();
        Date date3 = new Date();
        Date date4 = new Date();

        try {
            date1=DateFor.parse("18/05/2001");
            date2=DateFor.parse("25/11/1998");
            date3=DateFor.parse("23/05/2000");
            date4=DateFor.parse("19/09/2001");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        controller.adicionarColaborador(36, "Bea", "Beatriz Lira", date1, "Gaia", true, "bea@gmail.com", "colaborador", "colaborador", "919191991");
        controller.adicionarColaborador(8, "Pedro", "Pedro Morais", date2, "Matosinhos", true, "pedro@isep.ipp.pt", "colaborador", "colaborador", "939393939");
        controller.adicionarColaborador(5, "Joao", "Joao Moreira", date3, "Porto", true, "jm@isep.ipp.pt", "colaborador", "colaborador", "939993939");
        controller.adicionarColaborador(78, "Goncalo", "Goncalo Corredoura", date4, "Aveiro", true, "gc@isep.ipp.pt", "colaborador", "colaborador", "929292929");


        return true;
    }

}
