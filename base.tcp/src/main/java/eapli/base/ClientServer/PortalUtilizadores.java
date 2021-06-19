package eapli.base.ClientServer;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class PortalUtilizadores{


    private static final byte VERSION = 0;
    private static final byte NUMERO_TAREFAS_PENDENTES = 3;
    private static final byte NUMERO_TAREFAS_DEPOIS_PRAZO = 4;
    private static final byte NUMERO_TAREFAS_EM_MENOS_DE_UM_DIA = 5;
    private static final byte LISTA_TAREFAS_URGENCIA_CRITICIDADE = 6;
    private static final byte ATUALIZAR_PEDIDO = 7;
    private static final byte ACEITE = 8;
    private static final byte REJEITADO = 9;

    static InetAddress serverIP;
    static Socket sock;

    public void runMain() throws Exception {
        byte[] data = new byte[300];
        int numeroColaborador = 8;

        /*if(args.length!=1) {
            System.out.println(
                    "Server IPv4/IPv6 address or DNS name is required as argument");
            System.exit(1); }*/

        try { serverIP = InetAddress.getByName("192.168.1.71"); }
        catch(UnknownHostException ex) {
            System.out.println("Invalid server: " + "192.168.1.71");
            System.exit(1); }

        try {
            sock = new Socket(serverIP, 32507); }
        catch(Exception ex) {
            System.out.println("Failed to connect.");
            System.exit(1);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());

        System.out.println("Connected to server");

        // start a thread to read incoming messages from the server
        Thread serverConn = new Thread(new TcpChatCliConn(sock));
        serverConn.start();


        for(int i = 3; i < 7; i++) { // read messages from the console and send them to the server

            //falta aqui o algoritmo para ir buscar o numero do colaborador que fez log in.

            /*if(idPedido==0) {
                sOut.write(0);
                break;
            }
            data[0] = VERSION;
            data[1] = PEDIDO;
            data[2] = (Integer.SIZE/8);
            byte[] bytes = String.valueOf(idPedido).getBytes();
            data[3] = bytes[0];
            /*data[4] = bytes[1];
            data[5] = bytes[2];
            data[6] = bytes[3];*/

            data[0] = VERSION;
            data[1] = (byte) i;
            data[2] = (Byte.SIZE/8);
            byte[] bytes = String.valueOf(numeroColaborador).getBytes();
            data[3] = bytes[0];

            sOut.write(data[2]);
            sOut.write(data,0, data[2]);
        }

        serverConn.join();
        sock.close();
    }
}

class TcpChatCliConn implements Runnable{
    private Socket s;
    private DataInputStream sIn;

    private static final byte VERSION = 0;
    private static final byte NUMERO_TAREFAS_PENDENTES = 3;
    private static final byte NUMERO_TAREFAS_DEPOIS_PRAZO = 4;
    private static final byte NUMERO_TAREFAS_EM_MENOS_DE_UM_DIA = 5;
    private static final byte LISTA_TAREFAS_URGENCIA_CRITICIDADE = 6;
    private static final byte ATUALIZAR_PEDIDO = 7;
    private static final byte ACEITE = 8;
    private static final byte REJEITADO = 9;

    public TcpChatCliConn(Socket tcp_s) { s=tcp_s;}

    public void run() {
        int data_length;
        byte[] data = new byte[300];
        String frase;

        try {
            sIn = new DataInputStream(s.getInputStream());
            for(int i = 0; i < 4; i++) {
                data_length=sIn.read();
                if(data_length==0) break;
                sIn.read(data,0,data_length);
                String opcaoS = new String(data, 1, 1);
                int opcao = Integer.parseInt(opcaoS);

                if(opcao == NUMERO_TAREFAS_PENDENTES){
                    String numeroTarefasS = new String(data, 3, 1);
                    int numeroTarefas = Integer.parseInt(numeroTarefasS);
                    System.out.printf("O número de tarefas pendentes é %d.\n", numeroTarefas);
                }
                if(opcao == NUMERO_TAREFAS_DEPOIS_PRAZO){
                    String numeroTarefasS = new String(data,3 , 1);
                    int numeroTarefas = Integer.parseInt(numeroTarefasS);
                    System.out.printf("O número de tarefas depois do prazo de entrega é %d.\n", numeroTarefas);
                }
                if(opcao == NUMERO_TAREFAS_EM_MENOS_DE_UM_DIA){
                    String numeroTarefasS = new String(data, 3, 1);
                    int numeroTarefas = Integer.parseInt(numeroTarefasS);
                    System.out.printf("O número de tarefas cujo prazo acaba em menos de um dia é %d\n", numeroTarefas);
                }
                if(opcao == LISTA_TAREFAS_URGENCIA_CRITICIDADE){
                    String listaTarefas = new String(data, 3, data[2]);
                    System.out.printf("Os ids das tarefas ordenadas por urgência e criticidade são %s\n", listaTarefas);
                }

                /*frase = new String(data, 3, 1);
                int estadoPedido = Integer.parseInt(frase);
                String estado = null;
                if(estadoPedido == 1){
                    estado = "Submetido";
                }
                if(estadoPedido == 2){
                    estado = "Em aprovação";
                }
                if(estadoPedido == 3){
                    estado = "Aprovado";
                }
                if(estadoPedido == 4){
                    estado = "Rejeitado";
                }
                if(estadoPedido == 5){
                    estado = "Em resolução";
                }
                if(estadoPedido == 6){
                    estado = "Concluído";
                }
                if(estadoPedido == 7){
                    estado = "CONSEGUIMOS CARALHO!!!!!";
                }
                System.out.println("O pedido, neste momento, encontra-se no estado " + estado + "!");*/
            }
        }
        catch(IOException ex) { System.out.println("Client disconnected."); }
    }
}
