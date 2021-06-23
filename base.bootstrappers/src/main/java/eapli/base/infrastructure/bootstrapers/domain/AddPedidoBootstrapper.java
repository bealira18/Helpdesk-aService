package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.pedidomanagement.application.AdicionarPedidoController;
import eapli.base.pedidomanagement.application.FinalizarPedidoController;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedidomanagement.repository.PedidoRepository;
import eapli.base.tarefamanagement.application.CriarTarefaController;
import eapli.framework.actions.Action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddPedidoBootstrapper implements Action {

    AdicionarPedidoController apc = new AdicionarPedidoController();
    CriarTarefaController ctc = new CriarTarefaController();
    FinalizarPedidoController finalizarPedidoController=new FinalizarPedidoController();

    @Override
    public boolean execute() {

        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = new Date();
        Date date2 = new Date();
        Date date3 = new Date();
        Date date4 = new Date();

        try {
            date1=DateFor.parse("18/05/2020");
            date2=DateFor.parse("03/04/2021");
            date3=DateFor.parse("25/11/2019");
            date4=DateFor.parse("06/06/2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        apc.addPedido(date1,"u",8, "cod1");
        apc.addPedido(date2,"u",5, "cod1");
        apc.addPedido(date3,"u",36, "cod2");
        apc.addPedido(date4,"r",8, "cod1");

        ctc.novaTarefa("cod1", 1);
        ctc.novaTarefa("cod1", 2);
        ctc.novaTarefa("cod2", 3);
        ctc.novaTarefa("cod1", 4);

        finalizarPedidoController.finalizarPedido(1,"21/06/2021");
        finalizarPedidoController.finalizarPedido(4,"01/05/2021");

        return true;
    }

}
