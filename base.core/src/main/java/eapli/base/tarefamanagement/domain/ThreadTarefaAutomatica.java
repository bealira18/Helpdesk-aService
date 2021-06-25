package eapli.base.tarefamanagement.domain;

import eapli.base.Application;
import eapli.base.tarefamanagement.application.AtribuirTarefaAutomaticaController;


public class ThreadTarefaAutomatica extends Thread {

    InfoTarefa it;

    private AtribuirTarefaAutomaticaController atac = new AtribuirTarefaAutomaticaController();


    public ThreadTarefaAutomatica(InfoTarefa it) {
        this.it = it;
    }

    public void run(){
        int opcao = Application.settings().getAlgortihmOption2();
        if (opcao == 1){
            atac.atribuirTarefas1(it);
        }
        if (opcao == 2){
            atac.atribuirTarefas2(it);
        }
        System.out.println("Thread Terminada Com Sucesso!!");
    }
}
