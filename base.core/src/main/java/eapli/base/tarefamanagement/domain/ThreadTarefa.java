package eapli.base.tarefamanagement.domain;

import eapli.base.tarefamanagement.application.AtribuirTarefaManualController;

import java.util.List;

public class ThreadTarefa extends Thread {

    private AtribuirTarefaManualController atmc = new AtribuirTarefaManualController();

    public void run(){
        //try{
            //Thread.sleep(10000);
            atmc.fcfs();
        //} catch (InterruptedException ie){
            //System.out.println("Erro Thread Tarefa");
        //}
    }

    /*public void run(){
        List<InfoTarefa> tarefas = (List<InfoTarefa>) atmc.listarTarefasPendentes();
        InfoTarefa it = tarefas.get(0);
        if (it.obterTarefa().obterOption() == 1){
            atmc.atribuirTarefas1(it);
            System.out.printf("A InfoTarefa com id %d foi atribuída com sucesso pela forma 1", it.obterId());
        }
        if (it.obterTarefa().obterOption() == 2){
            atmc.atribuirTarefas2(it);
            System.out.printf("A InfoTarefa com id %d foi atribuída com sucesso pela forma 2", it.obterId());
        }
    }*/
}
