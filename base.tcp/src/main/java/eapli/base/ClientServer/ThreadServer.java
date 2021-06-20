package eapli.base.ClientServer;

import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.domain.ThreadTarefa;

import java.util.List;

public class ThreadServer extends Thread{

    public void run(){
        MotorFluxoAtividades server = new MotorFluxoAtividades();
        try {
            server.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}