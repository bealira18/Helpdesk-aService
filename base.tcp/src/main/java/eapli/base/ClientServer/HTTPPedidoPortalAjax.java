package eapli.base.ClientServer;

import java.io.*;
import java.net.*;


public class HTTPPedidoPortalAjax extends Thread {
    String baseFolder;
    Socket sock;
    DataInputStream inS;
    DataOutputStream outS;

    public HTTPPedidoPortalAjax(Socket s, String f) {
        baseFolder = f;
        sock = s;
    }

    public void run() {
        try {
            outS = new DataOutputStream(sock.getOutputStream());
            inS = new DataInputStream(sock.getInputStream());
        } catch (IOException ex) {
            System.out.println("Thread error on data streams creation");
        }
        try {
            System.out.println("1");
            HTTPmessage request = new HTTPmessage(inS);
            System.out.println("2");
            HTTPmessage response = new HTTPmessage();
            System.out.println("3");
            System.out.println(request.getURI());

            if (request.getMethod().equals("GET")) {
                if (request.getURI().equals("/votes")) {

                  //  response.setContentFromString(
                          //  HTTPServerAjax.getVotesStandingInHTML(), "text/html");
                    response.setResponseStatus("200 Ok");
                } else {
                    String fullname = baseFolder + "/";
                    if (request.getURI().equals("/")) fullname = fullname + "index.html";
                    else fullname = fullname + request.getURI();
                    if (response.setContentFromFile(fullname)) {
                        response.setResponseStatus("200 Ok");
                    } else {
                        response.setContentFromString(
                                "<html><body><h1>404 File not found</h1></body></html>",
                                "text/html");
                        response.setResponseStatus("404 Not Found");
                    }
                }
                response.send(outS);
            } else { // NOT GET
                if (request.getMethod().equals("PUT")
                        && request.getURI().startsWith("/votes/")) {
                    //HTTPServerAjax.castVote(request.getURI().substring(7));
                    response.setResponseStatus("200 Ok");
                } else {
                    response.setContentFromString(
                            "<html><body><h1>ERROR: 405 Method Not Allowed</h1></body></html>",
                            "text/html");
                    response.setResponseStatus("405 Method Not Allowed");
                }
                response.send(outS);
            }
        } catch (IOException ex) {
            System.out.println("Thread error when reading request");
        }
        try {
            sock.close();
        } catch (IOException ex) {
            System.out.println("CLOSE IOException");
        }
    }
}

