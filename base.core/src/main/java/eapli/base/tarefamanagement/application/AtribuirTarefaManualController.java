package eapli.base.tarefamanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.domain.EstadoTarefa;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.base.tarefamanagement.repository.InfoTarefaRepository;
import eapli.base.tarefamanagement.repository.TarefaManualRepository;

import java.util.ArrayList;
import java.util.List;

public class AtribuirTarefaManualController {

    private final InfoTarefaRepository infoTarefaRepository = PersistenceContext.repositories().infoTarefa();
    private final TarefaManualRepository tarefaManualRepository = PersistenceContext.repositories().tarefaManual();

    public void atribuirTarefas1(){
        fcfs();

    }

    public void atribuirTarefas2(){

    }

    public void fcfs(){

        List<InfoTarefa> tarefasPorAtribuir = listarTarefasPendentes();
        while(tarefasPorAtribuir.size()!=0) {
            InfoTarefa tarefa1 = tarefasPorAtribuir.get(0);
            for (InfoTarefa t : tarefasPorAtribuir) {
                if (t.obterDataInicio().compareTo(tarefa1.obterDataInicio()) < 0) {
                    tarefa1 = t;
                }
            }
            //atribuirTarefaAColaborador(tarefa1);
            tarefasPorAtribuir.remove(tarefa1);
        }
    }

    public List<InfoTarefa> listarTarefasPendentes(){
        List<TarefaManual> tarefasManuais = (List<TarefaManual>) tarefaManualRepository.findAll();
        //List<InfoTarefa> tarefas = procurarTarefasManuaisNaoAtribuidas();
        List<InfoTarefa> tarefas = (List<InfoTarefa>) infoTarefaRepository.findAll();
        List<InfoTarefa> tarefasPendentes = new ArrayList<>();
        for (InfoTarefa it : tarefas){
            for (TarefaManual tm : tarefasManuais){
                if(it.obteridTarefa()==tm.obterId() && it.obterEstado()== EstadoTarefa.NAO_INICIADA){
                    tarefasPendentes.add(it);
                }
            }
        }
        return tarefasPendentes;
    }

    public Iterable<InfoTarefa> listar(){
        return tarefaManualRepository.procurarTarefasManuaisNaoAtribuidas();
    }
}
