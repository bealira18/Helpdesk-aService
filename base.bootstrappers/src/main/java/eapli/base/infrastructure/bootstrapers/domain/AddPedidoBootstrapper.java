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

        SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
        Date d1=new Date();
        Date d2=new Date();
        Date d3=new Date();
        try {
            d1=forma.parse("18/05/2021");
            d2=forma.parse("03/09/2021");
            d3=forma.parse("25/11/2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        repository= PersistenceContext.repositories().pedido();
        Pedido pedido1=new Pedido(d1,"urgente",5,8);
        Pedido pedido2=new Pedido(d2,"urgente",5,8);
        Pedido pedido3=new Pedido(d3,"urgente",5,8);
        repository.save(pedido1);
        repository.save(pedido2);
        repository.save(pedido3);
        return false;
    }

}
