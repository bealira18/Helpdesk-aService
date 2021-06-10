package eapli.base.tarefamanagement.application;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.CriteriosEspecificacao;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.servicomanagement.repository.WorkflowRepository;
import eapli.base.tarefamanagement.domain.EstadoTarefa;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.repository.TarefaManualRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AtribuirTarefaManualController {

    private final TarefaManualRepository tarefaManualRepository = PersistenceContext.repositories().tarefaManual();
    private final WorkflowRepository workflowRepository = PersistenceContext.repositories().workflow();
    private final CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogo();

    public void atribuirTarefas1(InfoTarefa t1){
        
        List<Colaborador> colaboradoresDisponiveis = obterColaboradoresDisponiveis(t1);
        Colaborador colaboradorEscolhido = colaboradoresDisponiveis.get(0);
        List<InfoTarefa> tarefasEscolhido = colaboradorEscolhido.tarefas();
        Date dataUltimaTarefa = tarefasEscolhido.get(0).obterDataFim();
        for(InfoTarefa it : tarefasEscolhido){
            if (it.obterDataFim().compareTo(dataUltimaTarefa)>0){
                dataUltimaTarefa = it.obterDataFim();
            }
        }
        for(Colaborador c : colaboradoresDisponiveis){
            List<InfoTarefa> tarefas = c.tarefas();
            for(InfoTarefa it1 : tarefas){
                if (it1.obterDataFim().compareTo(dataUltimaTarefa)>0){
                    dataUltimaTarefa = it1.obterDataFim();
                    colaboradorEscolhido = c;
                }
            }
        }
        colaboradorEscolhido.reivindicarTarefa(t1);
        t1.mudarEstado(EstadoTarefa.ATRIBUIDA);
        //mandar email a avisar o colaborador
    }

    public void atribuirTarefas2(InfoTarefa t2){

    }

    public void fcfs(int option){

        List<InfoTarefa> tarefasPorAtribuir = (List<InfoTarefa>) listarTarefasPendentes();
        while(tarefasPorAtribuir.size()!=0) {
            InfoTarefa tarefa1 = tarefasPorAtribuir.get(0);
            for (InfoTarefa t : tarefasPorAtribuir) {
                if (t.obterDataInicio().compareTo(tarefa1.obterDataInicio()) < 0) {
                    tarefa1 = t;
                }
            }
            if(option == 1){
                atribuirTarefas1(tarefa1);
            }
            if(option == 2){
                atribuirTarefas2(tarefa1);
            }
            tarefasPorAtribuir.remove(tarefa1);
        }
    }

    /*public List<InfoTarefa> listarTarefasPendentes(){
        List<TarefaManual> tarefasManuais = (List<TarefaManual>) tarefaManualRepository.findAll();
        List<InfoTarefa> tarefas = procurarTarefasManuaisNaoAtribuidas();
        //List<InfoTarefa> tarefas = (List<InfoTarefa>) infoTarefaRepository.findAll();
        List<InfoTarefa> tarefasPendentes = new ArrayList<>();
        for (InfoTarefa it : tarefas){
            for (TarefaManual tm : tarefasManuais){
                if(it.obteridTarefa()==tm.obterId() && it.obterEstado()== EstadoTarefa.NAO_INICIADA){
                    tarefasPendentes.add(it);
                }
            }
        }
        return tarefasPendentes;
    }*/

    public Iterable<InfoTarefa> listarTarefasPendentes(){
        return tarefaManualRepository.procurarTarefasManuaisNaoAtribuidas();
    }

    public List<Colaborador> obterColaboradoresDisponiveis(InfoTarefa t1){
        int idTarefa = t1.obteridTarefa();
        Iterable<Workflow> workflows = workflowRepository.findAll();
        Workflow workflow = null;
        for (Workflow w : workflows){
            List<Tarefa> tarefas= w.obterTarefas();
            for (Tarefa t : tarefas){
                if(t.obterId()==idTarefa){
                    workflow = w;
                }
            }
        }
        Servico servico = workflow.obterServico();
        Iterable<Catalogo> catalogos = catalogoRepository.findAll();
        Catalogo catalogo = null;
        for (Catalogo c : catalogos){
            Iterable<Servico> servicos = c.servicos();
            for(Servico s : servicos){
                if(s.obterId()==servico.obterId()){
                    catalogo = c;
                }
            }
        }
        CriteriosEspecificacao ce = catalogo.obterCriteriosEspecificacao();
        List<Equipa> equipas = ce.obterEquipas();
        List<Colaborador> colaboradoresDisponiveis = new ArrayList<>();
        for(Equipa e : equipas){
            List<Colaborador> colaboradores = e.colaboradores();
            for(Colaborador c : colaboradores){
                colaboradoresDisponiveis.add(c);
            }
        }
        return colaboradoresDisponiveis;
    }
}
