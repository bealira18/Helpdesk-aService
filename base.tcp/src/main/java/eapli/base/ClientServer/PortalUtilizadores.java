package eapli.base.ClientServer;

import ch.qos.logback.core.net.ssl.SSL;
import eapli.base.colaboradormanagement.application.ColaboradorComUserController;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.repository.InfoTarefaRepository;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class PortalUtilizadores {


    private static final byte VERSION = 0;
    private static final byte NUMERO_TAREFAS_PENDENTES = 3;
    private static final byte NUMERO_TAREFAS_DEPOIS_PRAZO = 4;
    private static final byte NUMERO_TAREFAS_EM_MENOS_DE_UM_DIA = 5;
    private static final byte LISTA_TAREFAS_URGENCIA_CRITICIDADE = 6;
    private static final byte ATUALIZAR_PEDIDO = 7;
    private static final byte ACEITE = 8;
    private static final byte REJEITADO = 9;
    private static final byte DASHBOARD = 10;

    private final ColaboradorComUserController ccuc = new ColaboradorComUserController();

    static InetAddress serverIP;
    //static SSLSocket sock;
    static Socket sock;
    //static final String KEYSTORE_PASS="forgotten";
    //static final String TRUSTED_STORE="server_J.jks";

    public void runMain(int opcao, int idPedido) throws Exception {
        byte[] data = new byte[300];

        int numeroColaborador = ccuc.resultColaborador().obterNumero().obterNumero();

        /*if(args.length!=1) {
            System.out.println(
                    "Server IPv4/IPv6 address or DNS name is required as argument");
            System.exit(1); }*/

        //System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
        //System.setProperty("javax.net.ssl.trustStorePassword",KEYSTORE_PASS);

        // Use this certificate and private key for client certificate when requested by the server
        //System.setProperty("javax.net.ssl.keyStore", TRUSTED_STORE);
        //System.setProperty("javax.net.ssl.keyStorePassword",KEYSTORE_PASS);

        //SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();

        try {
            serverIP = InetAddress.getByName("localhost");
        } catch (UnknownHostException ex) {
            System.out.println("Invalid server: localhost");
            System.exit(1);
        }

        try {
            sock = new Socket(serverIP, 32507);
        } catch (Exception ex) {
            System.out.println("Failed to connect.");
            System.exit(1);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());

        System.out.println("Connected to server");

        //sock.startHandshake();

        // start a thread to read incoming messages from the server
        Thread serverConn = new Thread(new TcpChatCliConn(sock));
        serverConn.start();

        if(opcao == 1){
            data[0] = VERSION;
            data[1] = DASHBOARD;
            data[2] = (Byte.SIZE / 8);
            data[3] = (byte) numeroColaborador;
            sOut.write(data.length);
            sOut.write(data, 0, data.length);
        }
        if(opcao == 2){
            data[0] = VERSION;
            data[1] = ATUALIZAR_PEDIDO;
            data[2] = (Byte.SIZE / 8);
            data[3] = (byte) idPedido;
            sOut.write(data.length);
            sOut.write(data, 0, data.length);
        }

        serverConn.join();
        sock.close();
    }
}

class TcpChatCliConn implements Runnable {
    private static String fraseHtml;
    private static String fraseHtml1;
    private static String fraseHtml2;
    private static String fraseHtml3;
    private static String fraseHtml4;
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
    private static final byte DASHBOARD = 10;

    private final InfoTarefaRepository infoTarefaRepository = PersistenceContext.repositories().infoTarefa();

    public TcpChatCliConn(Socket tcp_s) {
        s = tcp_s;
    }


    public void run() {
        byte[] data = new byte[500];

        try {
            sIn = new DataInputStream(s.getInputStream());
            for (int i = 0; i < 1; i++) {
                int data_length = sIn.read();
                if (data_length == 0) break;
                sIn.read(data, 0, data_length);
                int opcao = data[1];

                if (opcao == NUMERO_TAREFAS_PENDENTES) {
                    int numeroTarefas = data[3];

                    fraseHtml = "</ul><hr><p>O número de tarefas pendentes é" + numeroTarefas + " </p><hr>";
                }
                if (opcao == NUMERO_TAREFAS_DEPOIS_PRAZO) {
                    int numeroTarefas = data[3];
                    fraseHtml = "Numero de tarefas depois do prazo de entrega -> " + numeroTarefas ;
                }
                if (opcao == NUMERO_TAREFAS_EM_MENOS_DE_UM_DIA) {
                    int numeroTarefas = data[3];
                    fraseHtml = "</ul><hr><p>O número de tarefas cujo prazo acaba em menos de um dia é " + numeroTarefas + " </p><hr>";
                }
                if (opcao == LISTA_TAREFAS_URGENCIA_CRITICIDADE) {
                    String listaTarefas = new String(data, 3, data[2]);
                    fraseHtml = "</ul><hr><p>Os ids das tarefas ordenadas por urgência e criticidade são " + listaTarefas + " </p><hr>";
                }
                if (opcao == DASHBOARD){
                    int tamanhoLength = data[2];
                    String tamanhoS = new String(data, 7, tamanhoLength);
                    int tamanho = Integer.parseInt(tamanhoS);
                    String dashboard = new String(data, 7+tamanhoLength, tamanho);
                    int tamanhoString1 = data[3];
                    int tamanhoString2 = data[4];
                    int tamanhoString3 = data[5];
                    int tamanhoString4 = data[6];
                    String string1 = new String(data, 7+tamanhoLength, tamanhoString1);
                    String string2 = new String(data, 7+tamanhoLength+tamanhoString1, tamanhoString2);
                    String string3 = new String(data, 7+tamanhoLength+tamanhoString1+tamanhoString2, tamanhoString3);
                    String string4 = new String(data, 7+tamanhoLength+tamanhoString1+tamanhoString2+tamanhoString3, tamanhoString4);
                    fraseHtml1 = string1;
                    fraseHtml2 = string2;
                    fraseHtml3 = string3;
                    String finalString4 = "Lista de tarefas: <br><br>";
                    byte[] string4Bytes = new byte[300];
                    string4Bytes = string4.getBytes();
                    int indexInicioIds = 0;
                    String idTarefas = null;
                    for( i = 0; i+2<string4Bytes.length; i++){
                        char char1 = (char) string4Bytes[i];
                        char char2 = (char) string4Bytes[i+1];
                        char char3 = (char) string4Bytes[i+2];
                        if(char1=='a' && char2=='s' && char3==':'){
                            indexInicioIds = i+4;
                        }
                    }
                    idTarefas = string4.substring(indexInicioIds);
                    String[] tarefasId = idTarefas.split(",");
                    for(String s : tarefasId){
                        int tarefaId = Integer.parseInt(s);
                        InfoTarefa infoTarefa = infoTarefaRepository.ofIdentity(tarefaId).get();
                        String aprovacao =null;
                        if(infoTarefa.obterTarefa().obterTipo()==true){
                            aprovacao = "Aprovacao";
                        } else {
                            aprovacao = "Realizacao";
                        }
                        String tarefaString = "Id: "+infoTarefa.obterId()+"<br>Data limite: "+infoTarefa.obterDataLimite()+
                                "<br>Prioridade: "+infoTarefa.obterPrioridade()+"<br>Tipo de tarefa: "+aprovacao+
                                "<br>Descricao: "+infoTarefa.obterTarefa().obterDescricao()+"<br> <br>";
                        finalString4 += tarefaString;
                    }
                    fraseHtml4 = finalString4;
                }

                String estado = null;

                if (opcao == ATUALIZAR_PEDIDO) {
                    int estadoPedido = data[3];
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
                    System.out.println("O pedido, neste momento, encontra-se no estado " + estado + "!");
                }
            }
        } catch (IOException ex) {
            System.out.println("Client disconnected.");
        }

    }

    public static String infoTarefasTCp() {

        return "<html><head><title>HTTP demo</title>" +
                "<body bgcolor=#92d6cc onload=\"refreshVotes()\">" +
                "<h1 > LAPR4 - 2DC - G5 </h1 > " +
                "<h3 > Goncalo Corredoura 1190617 / Beatriz Meireles 1200607 / Joao Moreira 1200615 </h3 > " +
                " </ul><hr><p>"+fraseHtml1+"</p><hr> </body ></html >" +
                " </ul><hr><p>"+fraseHtml2+"</p><hr> </body ></html >" +
                " </ul><hr><p>"+fraseHtml3+"</p><hr> </body ></html >" +
                " </ul><hr><p>"+fraseHtml4+"</p><hr> </body ></html >";
    }
}