package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedidomanagement.repository.PedidoRepository;
import eapli.framework.actions.Action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddPedidoBootstrapper implements Action {

    PedidoRepository repository;

    @Override
    public boolean execute() {

        repository= PersistenceContext.repositories().pedido();
        Pedido pedido1=new Pedido(new Date(2021 / 5 / 18),"urgente",8);
        Pedido pedido2=new Pedido(new Date(2021 / 9 / 3),"urgente",8);
        Pedido pedido3=new Pedido(new Date(2021 / 11 / 25),"urgente",8);
        repository.save(pedido1);
        repository.save(pedido2);
        repository.save(pedido3);
        return true;
    }

}
