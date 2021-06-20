package eapli.base.ClientServer;

import eapli.base.colaboradormanagement.application.ColaboradorComUserController;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.domain.ThreadTarefa;

import java.util.List;

public class ThreadClient extends Thread {


    public void run() {


        HTTPServerAjax client = new HTTPServerAjax();
        try {
            client.run();

            Runtime.getRuntime().exec(new String[]{"cmd", "/c","refresh chrome http://localhost:8080"});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
