package eapli.base.tarefamanagement.domain;

import eapli.base.tarefamanagement.application.AtribuirTarefaManualController;

import java.util.List;

public class ThreadPrincipal extends Thread {

    private AtribuirTarefaManualController atmc = new AtribuirTarefaManualController();

    public void run(){
        for(;;){
            try{
                Thread.sleep(30000);
                List<InfoTarefa> tarefasPorAtribuir = atmc.fcfs();
                if (tarefasPorAtribuir.size() != 0){
                    System.out.printf("O tamanho do array tarefas é %d\n", tarefasPorAtribuir.size());
                    if(tarefasPorAtribuir.size()>1) {
                        for (int i = 0; i < tarefasPorAtribuir.size(); i++) {
                            ThreadTarefa tt = new ThreadTarefa(tarefasPorAtribuir.get(i));
                            System.out.println("Thread Criada!");
                            tt.start();
                            Thread.sleep(10000);
                        }
                    }
                    if(tarefasPorAtribuir.size()==1){
                        ThreadTarefa tt = new ThreadTarefa(tarefasPorAtribuir.get(0));
                        System.out.println("Thread Criada!");
                        tt.start();
                    }
                }
            } catch (InterruptedException ie){
                System.out.println("Erro Thread Principal");
            }
        }
    }
}
