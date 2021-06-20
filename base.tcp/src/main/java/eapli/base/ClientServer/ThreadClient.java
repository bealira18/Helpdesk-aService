package eapli.base.ClientServer;

import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.domain.ThreadTarefa;

import java.util.List;

public class ThreadClient extends Thread{

    public void run(){
        HTTPServerAjax client = new HTTPServerAjax();
        try {
            client.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
