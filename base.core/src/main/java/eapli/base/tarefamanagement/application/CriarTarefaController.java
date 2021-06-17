package eapli.base.tarefamanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.domain.Urgencia;
import eapli.base.pedidomanagement.repository.PedidoRepository;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repository.ServicoRepository;
import eapli.base.tarefamanagement.domain.EstadoTarefa;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.repository.InfoTarefaRepository;
import eapli.base.tarefamanagement.repository.TarefaRepository;
import java.util.Date;
import java.util.List;

public class CriarTarefaController {

    private final TarefaRepository tarefaRepository = PersistenceContext.repositories().tarefa();
    private final InfoTarefaRepository infoTarefaRepository=PersistenceContext.repositories().infoTarefa();
    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servico();
    private final PedidoRepository pedidoRepository = PersistenceContext.repositories().pedido();

    public Tarefa criarTarefa(String descricao,boolean aprovacao) {

        final Tarefa novaTarefa = new Tarefa(descricao,aprovacao);

        return tarefaRepository.save(novaTarefa);

    }

    public void novaTarefa(String codServico, int idPedido){
        Pedido p = pedidoRepository.ofIdentity(idPedido).get();
        Servico s = servicoRepository.procurarPorCod(codServico);
        List<Tarefa> tarefas=s.obterWorkflow().obterTarefas();
        int prioridade=-1;

        if(p.obterUrgencia()==Urgencia.URGENTE){
            prioridade=5;
        }

        if(p.obterUrgencia()==Urgencia.MODERADA){
            prioridade=3;
        }

        if(p.obterUrgencia()==Urgencia.REDUZIDA){
            prioridade=1;
        }

        if(tarefas==null)
            return;

        InfoTarefa infoTarefa=new InfoTarefa();

        for(Tarefa t : tarefas){
            infoTarefa=new InfoTarefa(p.obterDataLimite(),prioridade);
            infoTarefa.associarTarefa(t);
            infoTarefaRepository.save(infoTarefa);
        }

    }

}
