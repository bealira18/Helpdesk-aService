package eapli.base.tarefamanagement.application;

import eapli.base.catalogomanagement.application.ListarCatálogosEServicosController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.servicomanagement.repository.ServicoRepository;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.base.tarefamanagement.repository.InfoTarefaRepository;
import eapli.base.tarefamanagement.repository.TarefaManualRepository;
import eapli.base.tarefamanagement.repository.TarefaRepository;
import eapli.framework.application.UseCaseController;

import java.util.*;

@UseCaseController
public class ConsultarTarefaController {

    private final TarefaRepository tarRepository = PersistenceContext.repositories().tarefa();
    private final ListarCatálogosEServicosController servicosController = new ListarCatálogosEServicosController();
    private final InfoTarefaRepository infoTarefaRepository = PersistenceContext.repositories().infoTarefa();

    public List<InfoTarefa> listarTarefasPendentes(int numColaborador) {

        List<InfoTarefa> tarefasPendentes = new ArrayList<>();
        List<Servico> servDoColaborador = servicosController.listarServicosDeCatalogo(numColaborador);
        Iterable<InfoTarefa> infoTarefas = infoTarefaRepository.findAll();
        for (Servico serv : servDoColaborador) {
            Workflow workflow = serv.obterWorkflow();
            if (workflow == null) {
                throw new IllegalArgumentException("Ainda não existem workflows.");
            } else {
                for (Tarefa tm : workflow.obterTarefas()) {
                    for (InfoTarefa it : infoTarefas) {
                        if (it.obteridTarefa() == tm.obterId() && tm.getClass().getSimpleName().compareTo("TarefaManual") == 0) {
                            tarefasPendentes.add(it);
                        }
                    }
                }
            }
        }

        if (tarefasPendentes == null) {
            throw new IllegalArgumentException("Não existem tarefas pendentes disponíveis para o colaborador.");
        }

        return tarefasPendentes;
    }

    public Iterable<InfoTarefa> tarefasporcolab(int id) {
        return infoTarefaRepository.filtarInfoTarefaporIdDoColaborador(id);
    }

    public void infoMinhasTarefas(Iterable<InfoTarefa> tarefas, int op, int numColaborador) {

        List<Servico> servicos = servicosController.listarServicosDeCatalogo(numColaborador);
        List<Date> datas = new ArrayList<>();

        if (op == 1) {
            //Ordenar por prioridade

            for (int i = 1; i < 6; i++) {
                for (InfoTarefa it : tarefas) {
                    if (it.obterPrioridade() == i) {
                        System.out.println("Tarefa de prioridade " + i);

                        Optional<Tarefa> tarefaOptional = tarRepository.ofIdentity(it.obteridTarefa());

                        if (tarefaOptional.get().obterTipo() == true) {
                            System.out.println("Tarefa de Aprovação");
                        } else {
                            System.out.println("Tarefa de Realização");
                        }
                        System.out.println("A tarefa termina a " + it.obterDataLimite().toString());
                        for (Servico serv : servicos) {
                            List<Tarefa> tarefasDoServico = serv.obterWorkflow().obterTarefas();
                            for (Tarefa t : tarefasDoServico) {
                                if (t.obterId() == it.obteridTarefa()) {
                                    System.out.println("Tarefa inserida no Serviço " + serv.obterTitulo());
                                    System.out.println("\n");
                                }
                            }

                        }
                    }
                }
            }

        } else {
            //Ordenar por Data Limite

            for (InfoTarefa it : tarefas) {
                datas.add(it.obterDataLimite());
            }

            Collections.sort(datas);

            for (Date data : datas) {
                for (InfoTarefa it : tarefas) {
                    if (data == it.obterDataLimite()) {

                        System.out.println("A tarefa termina a " + it.obterDataLimite().toString());
                        System.out.println("Tarefa de prioridade " + it.obterPrioridade());

                        Optional<Tarefa> tarefaOptional = tarRepository.ofIdentity(it.obteridTarefa());

                        if (tarefaOptional.get().obterTipo() == true) {
                            System.out.println("Tarefa de Aprovação");
                        } else {
                            System.out.println("Tarefa de Realização");
                        }
                        for (Servico serv : servicos) {
                            List<Tarefa> tarefasDoServico = serv.obterWorkflow().obterTarefas();
                            for (Tarefa t : tarefasDoServico) {
                                if (t.obterId() == it.obteridTarefa()) {
                                    System.out.println("Tarefa inserida no Serviço " + serv.obterTitulo());
                                    System.out.println("\n");
                                }
                            }

                        }
                    }
                }

            }
        }
    }
}
