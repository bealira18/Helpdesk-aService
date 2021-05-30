package eapli.base.appSDP2021management;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedidomanagement.domain.EstadoPedido;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.repository.PedidoRepository;
import eapli.base.tarefamanagement.domain.EstadoTarefa;
import eapli.base.tarefamanagement.domain.Tarefa;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ObterEstadoWorkflowServer {

    private static HashMap<Socket, DataOutputStream> cliList = new HashMap<>();

    public static synchronized void sendToAll(int len, byte[] data) throws Exception {
        for(DataOutputStream cOut: cliList.values()) {
            cOut.write(len);
            cOut.write(data,0,len);
        }

    }

    public static synchronized void addCli(Socket s) throws Exception {
        cliList.put(s,new DataOutputStream(s.getOutputStream()));
    }

    public static synchronized void remCli(Socket s) throws Exception {
        cliList.get(s).write(0);
        cliList.remove(s);
        s.close();
    }



    private static ServerSocket sock;

    public void run(String args[]) throws Exception {
        int i;

        try { sock = new ServerSocket(32507); }
        catch(IOException ex) {
            System.out.println("Local port number not available.");
            System.exit(1); }

        while(true) {
            Socket s=sock.accept(); // wait for a new client connection request
            addCli(s);
            Thread cli = new TcpChatSrvClient(s);
            cli.start();
        }
    }
}



class TcpChatSrvClient extends Thread {
    private Socket myS;
    private DataInputStream sIn;

    PedidoRepository pedidoRepository = PersistenceContext.repositories().pedido();

    public TcpChatSrvClient(Socket s) { myS=s;}

    public void run() {
        int nChars;
        byte[] data = new byte[300];

        try {
            sIn = new DataInputStream(myS.getInputStream());
            while(true) {
                nChars=sIn.read();
                if(nChars==0) break; // empty line means client wants to exit
                sIn.read(data,0,nChars);
                ObterEstadoWorkflowServer.sendToAll(nChars,data);
            }
            // the client wants to exit
            ObterEstadoWorkflowServer.remCli(myS);
        }
        catch(Exception ex) { System.out.println("Error"); }
    }

    public void EstadoSeguinte(int idPedido){
        Iterable<Pedido> pedidos = pedidoRepository.findAll();

        Pedido pedido = null;

        for (Pedido p : pedidos) {
            if (p.obterId()==idPedido) {
                pedido = p;
            }
        }

        if(pedido.obterEstadoPedido() == EstadoPedido.EM_APROVACAO){
            List<Tarefa> tarefas = new ArrayList<>();
            tarefas = pedido.obterListaTarefas();
            for(Tarefa t : tarefas){
                if (t.obterTipoTarefa()==true && t.obterEstadoTarefa()== EstadoTarefa.TERMINADA && t.obterAprovado()==1){
                    pedido.mudarEstadoPedido(EstadoPedido.APROVADO);
                }
            }
        }

    }
}

