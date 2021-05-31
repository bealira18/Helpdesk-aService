package eapli.base.appSDP2021management;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedidomanagement.repository.PedidoRepository;
import eapli.base.tarefamanagement.application.ConsultarTarefaController;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.domain.Tarefa;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;

public class ObterInfoTarefasServer {



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



class TcpChatSrvTarefasClient extends Thread {

    private static final byte VERSION = 0;
    private static final byte ACEITE = 4;
    private static final byte RECUSADO = 5;

    private Socket myS;
    private DataInputStream sIn;

    byte[] data = new byte[300];

    PedidoRepository pedidoRepository = PersistenceContext.repositories().pedido();
    public ConsultarTarefaController consultarTarefaController=new ConsultarTarefaController();

    public TcpChatSrvTarefasClient(Socket s) { myS=s;}

    public void run() {
        int nChars;

        try {
            sIn = new DataInputStream(myS.getInputStream());
            while(true) {
                nChars=sIn.read();
                if(nChars==0) break; // empty line means client wants to exit
                sIn.read(data,0,nChars);

                byte[] temp=new byte[300];
                temp[0]=data[3];
                temp[1]=data[4];
                temp[2]=data[5];
                temp[3]=data[6];

                String num=new String(data, 3, 4);
                int numColaborador=Integer.parseInt(num);

                data=tarefasPendentes(numColaborador);

                ObterInfoTarefasServer.sendToAll(nChars,data);
            }
            // the client wants to exit
            ObterEstadoWorkflowServer.remCli(myS);
        }
        catch(Exception ex) { System.out.println("Error"); }
    }

    public byte[] tarefasPendentes(int numColaborador){
        byte[] data = new byte[300];

        List<InfoTarefa> tarefas=consultarTarefaController.listarTarefasPendentes(numColaborador);

        if(tarefas.isEmpty()){
            data[0] = VERSION;
            data[1] = RECUSADO;
            data[2] = (Integer.SIZE/8);
            byte[] bytes = null;
            data[3] = bytes[0];
            data[4] = bytes[1];
            data[5] = bytes[2];
            data[6] = bytes[3];
        }else{
            int num=0;

            for(InfoTarefa t : tarefas){
                num++;
            }

            data[0] = VERSION;
            data[1] = ACEITE;
            data[2] = (Integer.SIZE/8);
            byte[] bytes = String.valueOf(num).getBytes();
            data[3] = bytes[0];
            data[4] = bytes[1];
            data[5] = bytes[2];
            data[6] = bytes[3];
            return data;
        }
        return null;
    }

}