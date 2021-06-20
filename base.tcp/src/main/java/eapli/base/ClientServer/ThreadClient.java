package eapli.base.ClientServer;

import eapli.base.colaboradormanagement.application.ColaboradorComUserController;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.domain.ThreadTarefa;

import java.util.List;

public class ThreadClient extends Thread {

    int opcao;
    int idPedido;

    public ThreadClient(int opcao, int idPedido) {
        this.opcao = opcao;
        this.idPedido = idPedido;
    }


    public void run() {

        HTTPServerAjax client = new HTTPServerAjax();
        try {
            client.run(opcao, idPedido);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
