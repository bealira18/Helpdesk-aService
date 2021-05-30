package eapli.base.appSDP2021management;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ObterInfoTarefasClient {

    private static final byte VERSION = 0;
    private static final byte PEDIDO = 3;

    static InetAddress serverIP;
    static Socket sock;


    public void run(String args[], int numColaborador) throws Exception {
        String nick, frase;
        byte[] data = new byte[300];

        if(args.length!=1) {
            System.out.println(
                    "Server IPv4/IPv6 address or DNS name is required as argument");
            System.exit(1); }

        try { serverIP = InetAddress.getByName(args[0]); }
        catch(UnknownHostException ex) {
            System.out.println("Invalid server: " + args[0]);
            System.exit(1); }

        try { sock = new Socket(serverIP, 0); }
        catch(IOException ex) {
            System.out.println("Failed to connect.");
            System.exit(1); }

        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());

        System.out.println("Connected to server");

        // start a thread to read incoming messages from the server
        Thread serverConn = new Thread(new TcpChatCliConnTarefas(sock));
        serverConn.start();


        while(true) { // read messages from the console and send them to the server
            if(numColaborador==0) {
                sOut.write(0);
                break;
            }
            data[0] = VERSION;
            data[1] = PEDIDO;
            data[2] = (Integer.SIZE/8);
            byte[] bytes = String.valueOf(numColaborador).getBytes();
            data[3] = bytes[0];
            data[4] = bytes[1];
            data[5] = bytes[2];
            data[6] = bytes[3];
            sOut.write(data[2]);
            sOut.write(data,0, data[2]);
        }

        serverConn.join();
        sock.close();
    }
}



class TcpChatCliConnTarefas implements Runnable {
    private Socket s;
    private DataInputStream sIn;

    public TcpChatCliConnTarefas(Socket tcp_s) { s=tcp_s;}

    public void run() {
        int data_length;
        byte[] data = new byte[300];
        String frase;

        try {
            sIn = new DataInputStream(s.getInputStream());
            while(true) {
                data_length=sIn.read();
                if(data_length==0) break;
                sIn.read(data,0,data_length);
                frase = new String(data, 3, data_length);
                int num=Integer.parseInt(frase);
                System.out.println("Numero tarefas pendentes: "+num);
            }
        }
        catch(IOException ex) { System.out.println("Client disconnected."); }
    }
}


