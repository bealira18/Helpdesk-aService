package eapli.base.tarefamanagement.domain;

import eapli.base.tarefamanagement.application.AtribuirTarefaManualController;

import java.util.List;

public class ThreadPrincipal extends Thread {

    private AtribuirTarefaManualController atmc = new AtribuirTarefaManualController();

    public void run(){
        for(;;){
            try{
                Thread.sleep(10000);
                List<InfoTarefa> tarefas = (List<InfoTarefa>) atmc.listarTarefasPendentes();
                if (tarefas.size() != 0){
                    System.out.printf("O tamanho do array tarefas é %d\n", tarefas.size());
                    for (int i = 0; i < tarefas.size(); i++){
                        ThreadTarefa tt = new ThreadTarefa();
                        System.out.println("Thread Criada!");
                        tt.start();
                        tt.join();
                    }
                }
            } catch (InterruptedException ie){
                System.out.println("Erro Thread Principal");
            }
        }
    }
}
