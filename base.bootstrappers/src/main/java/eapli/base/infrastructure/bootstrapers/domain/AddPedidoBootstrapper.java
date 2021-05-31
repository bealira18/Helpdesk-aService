package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.pedidomanagement.application.AdicionarPedidoController;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedidomanagement.repository.PedidoRepository;
import eapli.framework.actions.Action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddPedidoBootstrapper implements Action {

    PedidoRepository repository;
    AdicionarPedidoController apc = new AdicionarPedidoController();

    @Override
    public boolean execute() {

        apc.addPedido(new Date(2021 / 5 / 18),"urgente",8, "cod1");
        apc.addPedido(new Date(2021 / 9 / 3),"urgente",5, "cod2");
        apc.addPedido(new Date(2021 / 11 / 25),"urgente",36, "cod2");

        return true;
    }

}
