package eapli.base.appSDP2021management;


import java.io.*;
import java.net.*;

public class HTTP {
    static private Socket sock;
    static private InetAddress serverIP;
    static private int serverPort;
    static private DataOutputStream sOut;
    static private DataInputStream sIn;

    private static int numColadorador;

    public static void main(String args[]) throws Exception {

        if (args.length != 2) {
            System.out.println("Server address and port number required at command line.");
            System.out.println("Usage: java DemoConsumer {SERVER-ADDRESS} {SERVER-PORT-NUMBER}");
            System.exit(1);
        }

        try {
            serverIP = InetAddress.getByName(args[0]);
        } catch (UnknownHostException ex) {
            System.out.println("SERVER-ADDRESS inválido.");
            System.exit(1);
        }

        try {
            serverPort = Integer.parseInt(args[1]);
        } catch (NumberFormatException ex) {
            System.out.println("SERVER-PORT inválido.");
            System.exit(1);
        }

        HTTPMessage request = new HTTPMessage();
        request.setRequestMethod("PUT");
        request.setURI("/tarefas/" + numColadorador);
        System.out.println("Casting " + " tarefas do colaborador: " + numColadorador);

        try {
            sOut = new DataOutputStream(sock.getOutputStream());
            sIn = new DataInputStream(sock.getInputStream());
        } catch (IOException ex) {
            System.out.println("Erro a aceder aos streams do socket. Processo Cancelado.");
            try {
                sock.close();
            } catch (IOException ex2) {
                System.out.println("Erro a fechar o socket.");
            }
            System.out.println("Aplicação Cancelada.");
            System.exit(1);
        }
        System.out.println("Casting tarefa");
        request.send(sOut);
        HTTPMessage response = new HTTPMessage(sIn);
        System.out.println("Estado da resposta do servidor HTTP: " + response.getStatus());
        try {
            sock.close();
        } catch (IOException ex2) {
            System.out.println("Erro a fechar o socket.");
        }
    }

}

