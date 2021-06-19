package eapli.base.tarefamanagement.domain;

import eapli.base.Application;
import eapli.base.tarefamanagement.application.AtribuirTarefaManualController;

import java.util.List;

public class ThreadTarefa extends Thread {

    InfoTarefa it;

    private AtribuirTarefaManualController atmc = new AtribuirTarefaManualController();


    public ThreadTarefa(InfoTarefa it) {
        this.it = it;
    }

    public void run(){
        int opcao = Application.settings().getAlgortihmOption();
        if (opcao == 1){
            atmc.atribuirTarefas1(it);
        }
        if (opcao == 2){
            atmc.atribuirTarefas2(it);
        }
        System.out.println("Thread Terminada Com Sucesso!!");
    }
}
