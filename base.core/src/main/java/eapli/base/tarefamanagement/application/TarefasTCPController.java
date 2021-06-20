package eapli.base.tarefamanagement.application;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.domain.Urgencia;
import eapli.base.pedidomanagement.repository.PedidoRepository;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.servicomanagement.repository.ServicoRepository;
import eapli.base.servicomanagement.repository.WorkflowRepository;
import eapli.base.tarefamanagement.domain.EstadoTarefa;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.repository.InfoTarefaRepository;
import eapli.base.tarefamanagement.repository.TarefaRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TarefasTCPController {
    private final TarefaRepository tarefaRepository = PersistenceContext.repositories().tarefa();
    private final InfoTarefaRepository infoTarefaRepository = PersistenceContext.repositories().infoTarefa();
    private final PedidoRepository pedidoRepository = PersistenceContext.repositories().pedido();
    private final WorkflowRepository workflowRepository = PersistenceContext.repositories().workflow();
    private final CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogo();
    private final ServicoRepository servicoRepositoryRepository = PersistenceContext.repositories().servico();

    public int numTarefasPendentesDoColab(int numColab) {
        int contador = 0;
        Iterable<InfoTarefa> listaInfoTarefas = infoTarefaRepository.filtarInfoTarefaporIdDoColaborador(numColab);
        if (listaInfoTarefas == null) {
            throw new IllegalArgumentException("ERRO: Lista de info tarefas é nula!");
        } else {
            for (InfoTarefa infoTarefa : listaInfoTarefas) {
                if (infoTarefa.obterEstado().compareTo(EstadoTarefa.ATRIBUIDA) == 0 || infoTarefa.obterEstado().compareTo(EstadoTarefa.EM_EXECUÇAO)==0) {
                    contador++;
                }
            }
        }

        return contador;
    }

    public int numTarefasDpsPrazo(int numColab) {
        int contador = 0;
        int diferença = 0;
        Iterable<InfoTarefa> listaInfoTarefas = infoTarefaRepository.filtarInfoTarefaporIdDoColaborador(numColab);
        Date dataHoje = new Date(System.currentTimeMillis());
        if (listaInfoTarefas == null) {
            throw new IllegalArgumentException("ERRO: Lista de info tarefas é nula!");
        } else {
            for (InfoTarefa infoTarefa : listaInfoTarefas) {
                if (((dataHoje.getTime() - infoTarefa.obterDataLimite().getTime()) / 86400000) > 0 && infoTarefa.obterEstado()!=EstadoTarefa.TERMINADA) {
                    contador++;
                }
            }
        }


        return contador;
    }

    public int numTarefasTerminamEmMenos1Dia(int numColab) {
        //1Dia = 24h
        int contador = 0;
        int diferença = 0;
        Iterable<InfoTarefa> listaInfoTarefas = infoTarefaRepository.filtarInfoTarefaporIdDoColaborador(numColab);
        Date dataHoje = new Date(System.currentTimeMillis());
        if (listaInfoTarefas == null) {
            throw new IllegalArgumentException("ERRO: Lista de info tarefas é nula!");
        } else {
            for (InfoTarefa infoTarefa : listaInfoTarefas) {
                if (((dataHoje.getTime() - infoTarefa.obterDataLimite().getTime()) / 86400000) == 0 && infoTarefa.obterEstado()!=EstadoTarefa.TERMINADA) {
                    contador++;
                }
            }
        }


        return contador;
    }

    public Pedido obterPedidoPorIdInfoTarefa(int idInfoTarefa){
        List<Pedido> pedidos = (List<Pedido>) pedidoRepository.findAll();
        Pedido pedido = null;
        for(Pedido p : pedidos){
            List<InfoTarefa> tarefasPedido = p.obterListaTarefas();
            for(InfoTarefa it : tarefasPedido){
                if(it.obterId()==idInfoTarefa){
                    pedido = p;
                    break;
                }
            }
            if(pedido!=null){
                break;
            }
        }
        return pedido;
    }

    public Workflow obterWorkflowPorIdTarefa(int idTarefa){
        List<Workflow> workflows = (List<Workflow>) workflowRepository.findAll();
        Workflow workflow = null;
        for(Workflow w : workflows){
            List<Tarefa> tarefas = w.obterTarefas();
            for (Tarefa t : tarefas){
                if (t.obterId()==idTarefa){
                    workflow = w;
                    break;
                }
            }
            if (workflow!= null){
                break;
            }
        }
        return workflow;
    }

    public Catalogo obterCatalogoPorIdServico(int idServico){
        List<Catalogo> catalogos = (List<Catalogo>) catalogoRepository.findAll();
        Catalogo catalogo = null;
        for(Catalogo c : catalogos){
            List<Servico> servicos = c.servicos();
            for (Servico s : servicos){
                if (s.obterId()==idServico){
                    catalogo = c;
                    break;
                }
            }
            if (catalogo!=null){
                break;
            }
        }
        return catalogo;

    }

    public List<InfoTarefa> listarTarefasPorUrgenciaECriticidade(int numeroColaborador){
        Iterable<InfoTarefa> listaInfoTarefas = infoTarefaRepository.filtarInfoTarefaporIdDoColaborador(numeroColaborador);
        List<InfoTarefa> listaOrdenada = new ArrayList<>();

        if(listaInfoTarefas == null){
            throw new IllegalArgumentException("ERRO: Lista de info tarefas é nula!");
        }

        for(int i=2; i>=0; i--){
            for(int j=1; j<6; j++) {
                for (InfoTarefa it : listaInfoTarefas) {
                    Pedido pedido = obterPedidoPorIdInfoTarefa(it.obterId());
                    if (pedido.obterUrgencia().ordinal() == i) {
                        Tarefa tarefa = tarefaRepository.ofIdentity(it.obterTarefa().obterId()).get();
                        Workflow workflow = obterWorkflowPorIdTarefa(tarefa.obterId());
                        Servico servico = workflow.obterServico();
                        Catalogo catalogo = obterCatalogoPorIdServico(servico.obterId());
                        if (catalogo.obterNivelCriticidade().obterValor().obterValor() == j && it.obterEstado()!=EstadoTarefa.TERMINADA) {
                            listaOrdenada.add(it);
                        }
                    }
                }
            }
        }
        return listaOrdenada;
    }

    /*public List<InfoTarefa> listaTarefasUrgenciaCriticidade(int numColab) {
        Iterable<InfoTarefa> listaInfoTarefas = infoTarefaRepository.filtarInfoTarefaporIdDoColaborador(numColab);
        List<InfoTarefa> listaOrdenada = new ArrayList<>();

        if (listaInfoTarefas == null) {
            throw new IllegalArgumentException("ERRO: Lista de info tarefas é nula!");
        } else {


            for (int i = 1; i < 6; i++) {
                for (InfoTarefa infoTarefa : listaInfoTarefas) {
                    Pedido pedido = pedidoRepository.procurarPedidoPorIdInfoTarefa(infoTarefa.obterId());
                    if (pedido.obterUrgencia().compareTo(Urgencia.URGENTE) == 0) {
                        Tarefa tarefa = tarefaRepository.ofIdentity(infoTarefa.obteridTarefa()).get();
                        Workflow workflow = workflowRepository.ofIdentity(tarefa.obterId()).get();
                        Servico servico = servicoRepositoryRepository.ofIdentity(workflow.obterServico().obterId()).get();
                        Catalogo catalogo = catalogoRepository.procurarCatalogoPorIdServico(servico.obterId());
                        if (catalogo.obterNivelCriticidade().compareTo(i) == 0) {
                            listaOrdenada.add(infoTarefa);
                        }
                    }
                }

            }

            for (int i = 1; i < 6; i++) {
                for (InfoTarefa infoTarefa : listaInfoTarefas) {
                    Pedido pedido = pedidoRepository.procurarPedidoPorIdInfoTarefa(infoTarefa.obterId());
                    if (pedido.obterUrgencia().compareTo(Urgencia.MODERADA) == 0) {
                        Tarefa tarefa = tarefaRepository.ofIdentity(infoTarefa.obteridTarefa()).get();
                        Workflow workflow = workflowRepository.ofIdentity(tarefa.obterId()).get();
                        Servico servico = servicoRepositoryRepository.ofIdentity(workflow.obterServico().obterId()).get();
                        Catalogo catalogo = catalogoRepository.procurarCatalogoPorIdServico(servico.obterId());
                        if (catalogo.obterNivelCriticidade().compareTo(i) == 0) {
                            listaOrdenada.add(infoTarefa);
                        }
                    }
                }

            }

            for (int i = 1; i < 6; i++) {
                for (InfoTarefa infoTarefa : listaInfoTarefas) {
                    Pedido pedido = pedidoRepository.procurarPedidoPorIdInfoTarefa(infoTarefa.obterId());
                    if (pedido.obterUrgencia().compareTo(Urgencia.REDUZIDA) == 0) {
                        Tarefa tarefa = tarefaRepository.ofIdentity(infoTarefa.obteridTarefa()).get();
                        Workflow workflow = workflowRepository.ofIdentity(tarefa.obterId()).get();
                        Servico servico = servicoRepositoryRepository.ofIdentity(workflow.obterServico().obterId()).get();
                        Catalogo catalogo = catalogoRepository.procurarCatalogoPorIdServico(servico.obterId());
                        if (catalogo.obterNivelCriticidade().compareTo(i) == 0) {
                            listaOrdenada.add(infoTarefa);
                        }
                    }
                }

            }

        }

        return listaOrdenada;
    }*/
}
