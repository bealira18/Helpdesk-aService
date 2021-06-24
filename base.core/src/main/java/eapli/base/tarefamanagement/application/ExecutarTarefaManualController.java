package eapli.base.tarefamanagement.application;

//import eapli.base.ClientServer.ThreadClient;
//import eapli.base.ClientServer.ThreadServer;
import eapli.base.colaboradormanagement.application.ColaboradorComUserController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.repository.PedidoRepository;
import eapli.base.tarefamanagement.domain.EstadoTarefa;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.repository.InfoTarefaRepository;

import java.util.Calendar;
import java.util.List;

import static java.lang.Thread.sleep;

public class ExecutarTarefaManualController {

    private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaborador();
    private final InfoTarefaRepository infoTarefaRepository = PersistenceContext.repositories().infoTarefa();
    private final PedidoRepository pedidoRepository = PersistenceContext.repositories().pedido();

    public Pedido executarTarefaManual(int numeroColaborador, int idInfoTarefa){
        Colaborador colaborador = colaboradorRepository.ofIdentity(new Numero(numeroColaborador)).get();
        List<InfoTarefa> tarefas = colaborador.tarefas();
        for(InfoTarefa it : tarefas){
            if(it.obterId()==idInfoTarefa){
                it.mudarEstado(EstadoTarefa.TERMINADA);
                it.mudarDataFim(Calendar.getInstance().getTime());
                int tempoDecorrido = (int)((it.obterDataFim().getTime() - it.obterDataInicio().getTime())/60000);
                it.mudarTempoDecorrido(tempoDecorrido);
                infoTarefaRepository.save(it);
            }
        }

        List<Pedido> pedidos = (List<Pedido>) pedidoRepository.findAll();
        Pedido pedido = null;
        for(Pedido p : pedidos){
            List<InfoTarefa> tarefasPedido = p.obterListaTarefas();
            for(InfoTarefa t : tarefasPedido){
                if(t.obterId()==idInfoTarefa){
                    pedido = p;
                }
            }
        }

        return pedido;
    }

    public List<InfoTarefa> listarTarefasPendentesDoColaborador(int numeroColaborador){
        Colaborador colaborador = colaboradorRepository.ofIdentity(new Numero(numeroColaborador)).get();
        return colaborador.tarefas();
    }
}
