package eapli.base.pedidomanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedidomanagement.domain.EstadoPedido;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.repository.PedidoRepository;

import java.util.ArrayList;
import java.util.List;

public class PedidosColaboradorController {

    private final PedidoRepository pedidoRepository= PersistenceContext.repositories().pedido();

    public List<Pedido> historicoPedidos(int numeroColaborador){

        Iterable<Pedido> pedidos=pedidoRepository.findAll();
        List<Pedido> historicoPedidos=new ArrayList<>();

        for(Pedido p : pedidos){
            if(p.obterNumeroS()==numeroColaborador && p.obterEstadoPedido()==EstadoPedido.CONCLUIDO){
                historicoPedidos.add(p);
            }
        }
        return historicoPedidos;
    }

    public List<Pedido> pedidosEmCurso(int numeroColaborador){

        Iterable<Pedido> pedidos=pedidoRepository.findAll();
        List<Pedido> pedidosEmCurso=new ArrayList<>();

        for(Pedido p : pedidos){
            if(p.obterNumeroS()==numeroColaborador && p.obterEstadoPedido()!=EstadoPedido.CONCLUIDO){
                pedidosEmCurso.add(p);
            }
        }
        return pedidosEmCurso;
    }

}
