package eapli.base.tarefamanagement.domain;

import eapli.base.tarefamanagement.application.AtribuirTarefaManualController;

import java.util.List;

public class ThreadPrincipal extends Thread {

    private AtribuirTarefaManualController atmc = new AtribuirTarefaManualController();

    public void run(){
        for(;;){
            try{
                Thread.sleep(5000);
                List<InfoTarefa> tarefas = (List<InfoTarefa>) atmc.listarTarefasPendentes();
                if (tarefas.size() != 0){
                    for (int i = 0; i < tarefas.size(); i++){
                        ThreadTarefa tt = new ThreadTarefa();
                        tt.start();
                    }
                }
            } catch (InterruptedException ie){
                System.out.println("Erro Thread Principal");
            }
        }
    }
}
