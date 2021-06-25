package eapli.base.tarefamanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.domain.EstadoTarefa;
import eapli.base.tarefamanagement.domain.ExecutorTarefas;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.domain.TarefaAutomatica;
import eapli.base.tarefamanagement.repository.ExecutorTarefasRepository;
import eapli.base.tarefamanagement.repository.InfoTarefaRepository;
import eapli.base.tarefamanagement.repository.TarefaAutomaticaRepository;

import java.util.*;
import java.util.concurrent.Executor;

public class AtribuirTarefaAutomaticaController {

    private final InfoTarefaRepository infoTarefaRepository = PersistenceContext.repositories().infoTarefa();
    private final TarefaAutomaticaRepository tarefaAutomaticaRepository = PersistenceContext.repositories().tarefaAutomatica();
    private final ExecutorTarefasRepository executorTarefasRepository = PersistenceContext.repositories().executorTarefas();

    public List<InfoTarefa> listarTarefasAutomaticasPorAtribuir(){
        List<InfoTarefa> tarefas = (List<InfoTarefa>) infoTarefaRepository.findAll();
        List<TarefaAutomatica> tarefasAutomaticas = (List<TarefaAutomatica>) tarefaAutomaticaRepository.findAll();
        List<InfoTarefa> listaFinal = new ArrayList<>();
        for(InfoTarefa it : tarefas){
            for(TarefaAutomatica ta : tarefasAutomaticas){
                if(it.obterTarefa().obterId()==ta.obterId()){
                    if(it.obterEstado()== EstadoTarefa.NAO_INICIADA){
                        listaFinal.add(it);
                    }
                }
            }
        }
        return listaFinal;
    }

    public List<ExecutorTarefas> obterExecutoresDisponiveisPorOrdemId(){
        List<ExecutorTarefas> executores = (List<ExecutorTarefas>) executorTarefasRepository.findAll();
        Collections.sort(executores, new Comparator<ExecutorTarefas>() {
            @Override
            public int compare(ExecutorTarefas et1, ExecutorTarefas et2) {
                return et1.obterId() - et2.obterId();
            }
        });
        return executores;
    }

    public List<InfoTarefa> fcfs() {

        List<InfoTarefa> tarefasPorAtribuir = listarTarefasAutomaticasPorAtribuir();
        Collections.sort(tarefasPorAtribuir, new Comparator<InfoTarefa>() {
            @Override
            public int compare(InfoTarefa it1, InfoTarefa it2) {
                return it1.obterDataInicio().compareTo(it2.obterDataInicio());
            }
        });
        return tarefasPorAtribuir;
    }

    public boolean atribuirTarefas1(InfoTarefa t1){
        ExecutorTarefas executorEscolhido = null;
        List<ExecutorTarefas> executores = obterExecutoresDisponiveisPorOrdemId();
        if(executores.size()==0){
            System.out.println("Não existem executores disponíveis para a tarefa"+t1.obterId()+"!\n");
            return false;
        } else if(executores.size()==1){
            executorEscolhido = executores.get(0);
            System.out.printf("InfoTarefa com o id %d atribuída com sucesso pela forma 1, pelo facto de só haver um executor de tarefas disponível!\n", t1.obterId());
            guardarExecutorEscolhido(executorEscolhido, t1);
            return true;
        } else {
            int contadorExecutoresOcupados=0;
            for(ExecutorTarefas et : executores){
                if(et.obterOcupado()==true){
                    contadorExecutoresOcupados++;
                }
            }
            if(contadorExecutoresOcupados==0){
                executorEscolhido = executores.get(0);
                System.out.printf("InfoTarefa com o id %d atribuída com sucesso pela forma 1, pelo facto de nenhum executor estar ocupado!\n", t1.obterId());
                guardarExecutorEscolhido(executorEscolhido, t1);
                return true;
            }

            if(contadorExecutoresOcupados != 0 && contadorExecutoresOcupados < executores.size()){
                for(ExecutorTarefas et : executores){
                    if(et.obterOcupado()==false){
                        executorEscolhido = et;
                        System.out.printf("InfoTarefa com o id %d atribuída com sucesso pela forma 1, pelo facto do executor não estar ocupado!\n", t1.obterId());
                        guardarExecutorEscolhido(executorEscolhido, t1);
                        return true;
                    }
                }
            }
            if(contadorExecutoresOcupados == executores.size()){
                Date dataMaisRecenteExecutor = executores.get(0).tarefas().get(0).obterDataInicio();
                Date dataMaisAntigaGeral = dataMaisRecenteExecutor;
                executorEscolhido = executores.get(0);
                for(ExecutorTarefas et : executores){
                    List<InfoTarefa> tarefasExecutor = et.tarefas();
                    if(et!=executores.get(0)){
                       dataMaisRecenteExecutor = et.tarefas().get(0).obterDataInicio();
                    }
                    for(InfoTarefa it : tarefasExecutor){
                        if(it.obterDataInicio().compareTo(dataMaisRecenteExecutor)>0){
                            dataMaisRecenteExecutor = it.obterDataInicio();
                        }
                    }
                    if(et==executores.get(0)){
                        dataMaisAntigaGeral = dataMaisRecenteExecutor;
                    }
                    if(dataMaisRecenteExecutor.compareTo(dataMaisAntigaGeral)<0){
                        dataMaisAntigaGeral = dataMaisRecenteExecutor;
                        executorEscolhido = et;
                    }
                }
                System.out.printf("InfoTarefa com o id %d atribuída com sucesso pela forma 1 a um executor!\n", t1.obterId());
                guardarExecutorEscolhido(executorEscolhido, t1);
                return true;
            }

        }
        return true;
    }

    public boolean atribuirTarefas2(InfoTarefa t2){
        ExecutorTarefas executorEscolhido = null;
        List<ExecutorTarefas> executores = obterExecutoresDisponiveisPorOrdemId();
        if(executores.size()==0){
            System.out.println("Não existem executores disponíveis para a tarefa"+t2.obterId()+"!\n");
            return false;
        } else if(executores.size()==1){
            executorEscolhido = executores.get(0);
            System.out.printf("InfoTarefa com o id %d atribuída com sucesso pela forma 2, pelo facto de só haver um executor de tarefas disponível!\n", t2.obterId());
            guardarExecutorEscolhido(executorEscolhido, t2);
            return true;
        } else {
            int contadorExecutoresOcupados=0;
            for(ExecutorTarefas et : executores){
                if(et.obterOcupado()==true){
                    contadorExecutoresOcupados++;
                }
            }
            if(contadorExecutoresOcupados==0){
                executorEscolhido = executores.get(0);
                System.out.printf("InfoTarefa com o id %d atribuída com sucesso pela forma 2, pelo facto de nenhum executor estar ocupado!\n", t2.obterId());
                guardarExecutorEscolhido(executorEscolhido, t2);
                return true;
            }

            if(contadorExecutoresOcupados != 0 && contadorExecutoresOcupados < executores.size()){
                for(ExecutorTarefas et : executores){
                    if(et.obterOcupado()==false){
                        executorEscolhido = et;
                        System.out.printf("InfoTarefa com o id %d atribuída com sucesso pela forma 2, pelo facto do executor não estar ocupado!\n", t2.obterId());
                        guardarExecutorEscolhido(executorEscolhido, t2);
                        return true;
                    }
                }
            }
            if(contadorExecutoresOcupados == executores.size()){
                int numeroTarefasExecutor = executores.get(0).tarefas().size();
                executorEscolhido = executores.get(0);
                for(ExecutorTarefas et : executores){
                    if(et.tarefas().size() < numeroTarefasExecutor){
                        numeroTarefasExecutor = et.tarefas().size();
                        executorEscolhido = et;
                    }
                }
                System.out.printf("InfoTarefa com o id %d atribuída com sucesso pela forma 2 a um executor!\n", t2.obterId());
                guardarExecutorEscolhido(executorEscolhido, t2);
                return true;
            }

        }
        return true;
    }

    public void guardarExecutorEscolhido(ExecutorTarefas executorEscolhido, InfoTarefa infoTarefa){
        executorEscolhido.reivindicarTarefa(infoTarefa);
        if(executorEscolhido.obterOcupado()==false){
            executorEscolhido.mudarOcupado(true);
        }
        infoTarefa.associarExecutor(executorEscolhido);
        infoTarefa.mudarEstado(EstadoTarefa.ATRIBUIDA);
        executorTarefasRepository.save(executorEscolhido);
        infoTarefaRepository.save(infoTarefa);
    }


}
