package eapli.base.tarefamanagement.domain;

import eapli.base.tarefamanagement.application.AtribuirTarefaAutomaticaController;

import java.util.List;

public class ThreadPrincipalAutomatica extends Thread {

    private AtribuirTarefaAutomaticaController atac = new AtribuirTarefaAutomaticaController();

    public void run(){
        for(;;){
            try{
                Thread.sleep(30000);
                List<InfoTarefa> tarefasPorAtribuir = atac.fcfs();
                if (tarefasPorAtribuir.size() != 0){
                    System.out.printf("O tamanho do array tarefas é %d\n", tarefasPorAtribuir.size());
                    if(tarefasPorAtribuir.size()>1) {
                        for (int i = 0; i < tarefasPorAtribuir.size(); i++) {
                            ThreadTarefaAutomatica tt = new ThreadTarefaAutomatica(tarefasPorAtribuir.get(i));
                            System.out.println("Thread Criada!");
                            tt.start();
                            Thread.sleep(10000);
                        }
                    }
                    if(tarefasPorAtribuir.size()==1){
                        ThreadTarefaAutomatica tt = new ThreadTarefaAutomatica(tarefasPorAtribuir.get(0));
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