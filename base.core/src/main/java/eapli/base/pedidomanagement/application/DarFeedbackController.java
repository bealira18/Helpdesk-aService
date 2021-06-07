package eapli.base.pedidomanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedidomanagement.domain.Feedback;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.repository.PedidoRepository;

public class DarFeedbackController {

    private final PedidoRepository pedidoRepository= PersistenceContext.repositories().pedido();

    public Pedido darFeedback(int idPedido,int feedback){

        Pedido pedido=procurarPedidoID(idPedido);

        if(pedido==null)
            throw new IllegalArgumentException("Não existe nenhum pedido com o id: " + idPedido);

        pedido.darFeedback(new Feedback(feedback));

        return pedidoRepository.save(pedido);
    }

    public Pedido procurarPedidoID(int id){
        return pedidoRepository.ofIdentity(id).get();
    }

    public Iterable<Pedido> pedidosFinalizados(int num){
        return pedidoRepository.pedidosFinalizados(num);
    }

    public Pedido procurarPedido(int id,Iterable<Pedido> pedidos){
        for(Pedido p : pedidos){
            if(p.obterId()==id){
                return p;
            }
        }
        return null;
    }

}
