package eapli.base.ClientServer;


import ch.qos.logback.core.net.ssl.SSL;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServerAjax {

    static private final String BASE_FOLDER = "www";
    static private ServerSocket sock;
    //static private ServerSocket sock;
    static SSLSocket socket;
    //static Socket socket;
    static InetAddress serverIP;
    private static int accessesCounter;
    private static final byte VERSION = 0;

    public void run(int opcao, int idPedido) throws Exception {
        //SSLSocket cliSock;
        Socket cliSock;
        byte[] data = new byte[300];

        /*if(args.length!=1) {
            System.out.println("Local port number required at the command line.");
            System.exit(1);
        }

        accessesCounter=0;
        for(int i=0;i<candidatesNumber; i++) {
            candidateName[i] = "Candidate " + i;
            candidateVotes[i] = 0;
        }*/



        if(opcao==1) {

            try {
                // SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
                sock = new ServerSocket(8080);
            } catch (IOException ex) {
                System.out.println("Local port number not available: 8080");
                System.exit(1);
            }
        }

        PortalUtilizadores pu = new PortalUtilizadores();
        pu.runMain(opcao, idPedido);


        if(opcao==1) {

            while (true) {
                cliSock = sock.accept();
                HTTPPedidoPortalAjax req = new HTTPPedidoPortalAjax(cliSock, BASE_FOLDER);
                req.start();
            }
        }
    }


}
