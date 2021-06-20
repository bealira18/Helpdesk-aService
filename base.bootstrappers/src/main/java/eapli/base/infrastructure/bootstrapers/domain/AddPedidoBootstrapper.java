package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.pedidomanagement.application.AdicionarPedidoController;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedidomanagement.repository.PedidoRepository;
import eapli.base.tarefamanagement.application.CriarTarefaController;
import eapli.framework.actions.Action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddPedidoBootstrapper implements Action {

    PedidoRepository repository;
    AdicionarPedidoController apc = new AdicionarPedidoController();
    CriarTarefaController ctc = new CriarTarefaController();

    @Override
    public boolean execute() {

        apc.addPedido(new Date(2021 / 5 / 18),"u",8, "cod1");
        apc.addPedido(new Date(2021 / 9 / 3),"u",5, "cod1");
        apc.addPedido(new Date(2021 / 11 / 25),"u",36, "cod2");

        ctc.novaTarefa("cod1", 1);
        ctc.novaTarefa("cod1", 2);
        ctc.novaTarefa("cod2", 2);

        return true;
    }

}
