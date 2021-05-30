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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsultarTarefaController {

    private final TarefaRepository tarRepository = PersistenceContext.repositories().tarefa();
    private final ListarCatálogosEServicosController servicosController = new ListarCatálogosEServicosController();
    private final InfoTarefaRepository infoTarefaRepository = PersistenceContext.repositories().infoTarefa();
    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servico();

    public List<Tarefa> listarTarefasPendentes(int numColaborador) {

        List<Tarefa> tarefasPendentes = new ArrayList<>();
        List<Servico> servDoColaborador = servicosController.listarServicosDeCatalogo(numColaborador);

        for (Servico serv : servDoColaborador) {
            Workflow workflow = serv.obterWorkflow();
            if(workflow == null){
                throw new IllegalArgumentException("Ainda não existem workflows.");
            } else{
                for(Tarefa tm: workflow.obterTarefas()){
                    if (tm.getClass().getSimpleName().compareTo("TarefaManual") == 0) {
                        tarefasPendentes.add(tm);

                    }

            }


            }
        }


        if (tarefasPendentes == null) {
            throw new IllegalArgumentException("Não existem tarefas pendentes disponíveis para o colaborador.");
        }

        return tarefasPendentes;
    }

    public List<InfoTarefa> listarMinhasTarefas(int id) {

        Iterable<InfoTarefa> tarefas = infoTarefaRepository.findAll();
        List<InfoTarefa> tarefasPendentes = new ArrayList<>();


        for (InfoTarefa iT : tarefas) {
            if (iT.obterIdColaborador() == id) {
                tarefasPendentes.add(iT);
            }
        }

        if (tarefasPendentes == null) {
            throw new IllegalArgumentException("Não existem tarefas pendentes para o colaborador indicado.");
        }

        return tarefasPendentes;
    }

    public void infoMinhasTarefas(List<InfoTarefa> tarefas, int op, int numColaborador) {
        Iterable<Tarefa> tar = tarRepository.findAll();

        List<Servico> servicos = servicosController.listarServicosDeCatalogo(numColaborador);

        List<Date> datas = new ArrayList<>();

        if (op == 1) {
            //Ordenar por prioridade

            for (int i = 1; i < 6; i++) {
                for (InfoTarefa it : tarefas) {
                    if (it.obterPrioridade() == i) {
                        System.out.println("Tarefa de prioridade " + i);
                        for (Tarefa tarefa : tar) {
                            if (tarefa.obterId() == it.obteridTarefa()) {
                                if (tarefa.obterTipo() == true) {
                                    System.out.println("Tarefa de Aprovação");
                                } else {
                                    System.out.println("Tarefa de Realização");
                                }
                            }
                        }
                        System.out.println("A tarefa termina a " + it.obterDataLimite().toString());
                        for (Servico serv : servicos) {
                            List<Tarefa> tarefasDoServico = serv.obterWorkflow().obterTarefas();
                            for (Tarefa t : tarefasDoServico) {
                                if (t.obterId() == it.obteridTarefa()) {
                                    System.out.println("Tarefa inserida no Serviço " + serv.obterTitulo());
                                }
                            }

                        }
                    }
                }

            }
        }
        /*else{
            //Ordenar por Data Limite

            for(InfoTarefa it: tarefas){
                datas.add(it.obterDataLimite());
            }
            for(Date)
        }*/
    }
}
