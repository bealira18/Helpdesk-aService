package eapli.base.pedidomanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.repository.PedidoRepository;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repository.ServicoRepository;

import java.util.Date;

public class AdicionarPedidoController {

    private final PedidoRepository pedidoRepository= PersistenceContext.repositories().pedido();
    private final ServicoRepository servicoRepository=PersistenceContext.repositories().servico();;

    public Pedido addPedido(Date dataLimite, String urgencia, int numeroS/*, int numeroD*/,String codServico){

        Servico servico=procurarServicoCod(codServico);

        if(servico==null)
            throw new IllegalArgumentException("Servico inválido com codigo: "+codServico);

        final Pedido novoPedido=new Pedido(dataLimite,urgencia,numeroS/*,numeroD*/);

        novoPedido.associarServico(servico);
        novoPedido.associarWorkflow(servico.obterWorkflow());

        return pedidoRepository.save(novoPedido);
    }

    public Servico procurarServicoCod(String cod){
        return servicoRepository.procurarPorCod(cod);
    }

    /*public boolean verificarServico(int idServico){

        if(servicoRepository.ofIdentity(idServico).isEmpty())
            return false;

        return true;
    }*/

    /*public int codParaId(String cod){

        Iterable<Servico> servicos=servicoRepository.findAll();

        for(Servico s : servicos){
            if(s.obterCod().equals(cod))
                return s.obterId();
        }
        return 0;
    }*/

    /*public Servico servicoComId(int id){
        Iterable<Servico> servicos=servicoRepository.findAll();

        for(Servico s : servicos){
            if(s.obterId()==id)
                return s;
        }
        return null;
    }*/

}
