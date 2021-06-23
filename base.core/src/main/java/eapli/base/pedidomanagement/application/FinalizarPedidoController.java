package eapli.base.pedidomanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedidomanagement.domain.EstadoPedido;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.repository.PedidoRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class FinalizarPedidoController {

    private final PedidoRepository pedidoRepository= PersistenceContext.repositories().pedido();

    public void finalizarPedido(int id,String dateS){
        Optional<Pedido> p=pedidoRepository.ofIdentity(id);

        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = new Date();

        try {
            date1=DateFor.parse(dateS);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        p.get().mudarDataFim(date1);
        p.get().mudarEstadoPedido(EstadoPedido.CONCLUIDO);

        pedidoRepository.save(p.get());
    }

}
