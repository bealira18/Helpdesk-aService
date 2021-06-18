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
                if (infoTarefa.obterEstado().compareTo(EstadoTarefa.ATRIBUIDA) == 0) {
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
                if (((dataHoje.getTime() - infoTarefa.obterDataLimite().getTime()) / 86400000) > 0) {
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
                if (((dataHoje.getTime() - infoTarefa.obterDataLimite().getTime()) / 86400000) == 0) {
                    contador++;
                }
            }
        }


        return contador;
    }

    public List<InfoTarefa> listaTarefasUrgenciaCriticidade(int numColab) {
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
    }
}
