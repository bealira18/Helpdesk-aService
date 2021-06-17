package eapli.base.ClientServer;

import eapli.base.tarefamanagement.application.PesquisarTarefaController;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import org.h2.tools.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class MotorFluxoAtividades {

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


    public static void main(String args[]) throws Exception {
        Server server = Server.createTcpServer(args).start();
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
        //server.stop();
    }
}

class TcpChatSrvClient extends Thread {
    private Socket myS;
    private DataInputStream sIn;
    private static final byte VERSION = 0;
    private static final byte ACEITE = 4;
    private static final byte REJEITADO = 5;

    //PedidoRepository pedidoRepository = PersistenceContext.repositories().pedido();
    private PesquisarTarefaController ptc = new PesquisarTarefaController();

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
                String pedido = new String(data, 3, 1);
                int idPedido = Integer.parseInt(pedido);

                InfoTarefa it = ptc.procurarInfoTarefaPorID(idPedido);
                int idTarefa = it.obteridTarefa();

                data[0] = VERSION;
                data[1] = ACEITE;
                data[2] = (Integer.SIZE/8);
                byte[] bytes = String.valueOf(idTarefa).getBytes();
                data[3] = bytes[0];
                /*data[4] = bytes[1];
                data[5] = bytes[2];
                data[6] = bytes[3];*/

                //data = estadoSeguinte(idPedido);
                MotorFluxoAtividades.sendToAll(nChars,data);
            }
            // the client wants to exit
            MotorFluxoAtividades.remCli(myS);
        }
        catch(Exception ex) { System.out.println("Error"); }
    }



    /*public byte[] estadoSeguinte(int idPedido){

        byte[] data = new byte[300];
        Iterable<Pedido> pedidos = pedidoRepository.findAll();

        Pedido pedido = null;

        for (Pedido p : pedidos) {
            if (p.obterId()==idPedido) {
                pedido = p;
            }
        }

        if(pedido == null){
            data[1] = REJEITADO;
        }else {
            data[1] = ACEITE;
        }

        if(pedido.obterEstadoPedido() == EstadoPedido.EM_APROVACAO){
            List<Tarefa> tarefas;
            tarefas = pedido.obterListaTarefas();
            for(Tarefa t : tarefas){
                if (t.obterTipo()==true && t.obterEstadoTarefa()== EstadoTarefa.TERMINADA && t.obterAprovado()==1){
                    pedido.mudarEstadoPedido(EstadoPedido.APROVADO);
                    int resultado = 3;
                    data[0] = VERSION;
                    data[2] = (Integer.SIZE/8);
                    byte[] bytes = String.valueOf(resultado).getBytes();
                    data[3] = bytes[0];
                    data[4] = bytes[1];
                    data[5] = bytes[2];
                    data[6] = bytes[3];
                    return data;
                }
                if (t.obterTipo()==true && t.obterEstadoTarefa()== EstadoTarefa.TERMINADA && t.obterAprovado()==-1){
                    pedido.mudarEstadoPedido(EstadoPedido.REJEITADO);
                    int resultado = 4;
                    data[0] = VERSION;
                    data[2] = (Integer.SIZE/8);
                    byte[] bytes = String.valueOf(resultado).getBytes();
                    data[3] = bytes[0];
                    data[4] = bytes[1];
                    data[5] = bytes[2];
                    data[6] = bytes[3];
                    return data;
                }
                if (t.obterTipo()==true && (t.obterEstadoTarefa()== EstadoTarefa.EM_EXECUÇAO || t.obterEstadoTarefa()==EstadoTarefa.ATRIBUIDA)){
                    int resultado = 2;
                    data[0] = VERSION;
                    data[2] = (Integer.SIZE/8);
                    byte[] bytes = String.valueOf(resultado).getBytes();
                    data[3] = bytes[0];
                    data[4] = bytes[1];
                    data[5] = bytes[2];
                    data[6] = bytes[3];
                    return data;
                }
            }

        }
        if(pedido.obterEstadoPedido() == EstadoPedido.EM_RESOLUCAO) {
            List<Tarefa> tarefas = new ArrayList<>();
            tarefas = pedido.obterListaTarefas();
            for (Tarefa t : tarefas) {
                if (t.obterTipo() == false && t.obterEstadoTarefa() == EstadoTarefa.TERMINADA) {
                    pedido.mudarEstadoPedido(EstadoPedido.CONCLUIDO);
                    int resultado = 6;
                    data[0] = VERSION;
                    data[2] = (Integer.SIZE / 8);
                    byte[] bytes = String.valueOf(resultado).getBytes();
                    data[3] = bytes[0];
                    data[4] = bytes[1];
                    data[5] = bytes[2];
                    data[6] = bytes[3];
                    return data;
                }
                if (t.obterTipo() == false && (t.obterEstadoTarefa() == EstadoTarefa.EM_EXECUÇAO || t.obterEstadoTarefa() == EstadoTarefa.ATRIBUIDA)) {
                    int resultado = 5;
                    data[0] = VERSION;
                    data[2] = (Integer.SIZE / 8);
                    byte[] bytes = String.valueOf(resultado).getBytes();
                    data[3] = bytes[0];
                    data[4] = bytes[1];
                    data[5] = bytes[2];
                    data[6] = bytes[3];
                    return data;
                }
            }
        }
        if(pedido.obterEstadoPedido() == EstadoPedido.SUBMETIDO) {
            int resultado = 1;
            data[0] = VERSION;
            data[2] = (Integer.SIZE / 8);
            byte[] bytes = String.valueOf(resultado).getBytes();
            data[3] = bytes[0];
            data[4] = bytes[1];
            data[5] = bytes[2];
            data[6] = bytes[3];
            return data;
        }
        return null;
    }*/
}
