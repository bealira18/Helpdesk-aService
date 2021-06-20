package eapli.base.ClientServer;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedidomanagement.domain.EstadoPedido;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.repository.PedidoRepository;
import eapli.base.tarefamanagement.application.PesquisarTarefaController;
import eapli.base.tarefamanagement.application.TarefasTCPController;
import eapli.base.tarefamanagement.domain.EstadoTarefa;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import org.h2.tools.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;

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
    private static final byte NUMERO_TAREFAS_PENDENTES = 3;
    private static final byte NUMERO_TAREFAS_DEPOIS_PRAZO = 4;
    private static final byte NUMERO_TAREFAS_EM_MENOS_DE_UM_DIA = 5;
    private static final byte LISTA_TAREFAS_URGENCIA_CRITICIDADE = 6;
    private static final byte ATUALIZAR_PEDIDO = 7;
    private static final byte ACEITE = 8;
    private static final byte REJEITADO = 9;

    PedidoRepository pedidoRepository = PersistenceContext.repositories().pedido();
    private PesquisarTarefaController ptc = new PesquisarTarefaController();
    private TarefasTCPController ttc = new TarefasTCPController();

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
                int opcao = data[1];
                if(opcao == NUMERO_TAREFAS_PENDENTES){
                    int colaborador = data[3];
                    data = numeroTarefasPendentesColaborador(colaborador);
                }
                if(opcao == NUMERO_TAREFAS_DEPOIS_PRAZO){
                    int colaborador = data[3];
                    data = numeroTarefasDepoisPrazo(colaborador);
                }
                if(opcao == NUMERO_TAREFAS_EM_MENOS_DE_UM_DIA){
                    int colaborador = data[3];
                    data = numeroTarefasEmMenosDeUmDia(colaborador);
                }
                if(opcao == LISTA_TAREFAS_URGENCIA_CRITICIDADE){
                    int colaborador = data[3];
                    data = listaTarefasUrgenciaCriticidade(colaborador);
                }
                if(opcao == ATUALIZAR_PEDIDO){
                    int idPedido = data[3];
                    data = atualizarEstadoPedido(idPedido);
                }

                /*InfoTarefa it = ptc.procurarInfoTarefaPorID(idPedido);
                int idTarefa = it.obteridTarefa();

                data[0] = VERSION;
                data[1] = ACEITE;
                data[2] = (Integer.SIZE/8);
                byte[] bytes = String.valueOf(idTarefa).getBytes();
                data[3] = bytes[0];
                data[4] = bytes[1];
                data[5] = bytes[2];
                data[6] = bytes[3];*/

                MotorFluxoAtividades.sendToAll(data.length,data);
            }
            // the client wants to exit
            MotorFluxoAtividades.remCli(myS);
        }
        catch(Exception ex) { System.out.println("Error"); }
    }



    public byte[] atualizarEstadoPedido(int idPedido){

        byte[] data = new byte[300];

        Pedido pedido = pedidoRepository.ofIdentity(idPedido).get();

        if(pedido == null) {
            data[0] = VERSION;
            data[1] = REJEITADO;
            data[2] = 0;
            return data;
        } else {
            data[1] = ATUALIZAR_PEDIDO;
        }

        if(pedido.obterEstadoPedido() == EstadoPedido.EM_APROVACAO){
            List<InfoTarefa> tarefas;
            tarefas = pedido.obterListaTarefas();
            for(InfoTarefa t : tarefas){
                if (t.obterTarefa().obterTipo()==true && t.obterEstado()== EstadoTarefa.TERMINADA && t.obterTarefa().obterAprovado()==1){
                    pedido.mudarEstadoPedido(EstadoPedido.APROVADO);
                    int resultado = 3;
                    data[0] = VERSION;
                    data[2] = (Byte.SIZE/8);
                    data[3] = (byte) resultado;
                    return data;
                }
                if (t.obterTarefa().obterTipo()==true && t.obterEstado()== EstadoTarefa.TERMINADA && t.obterTarefa().obterAprovado()==-1){
                    pedido.mudarEstadoPedido(EstadoPedido.REJEITADO);
                    int resultado = 4;
                    data[0] = VERSION;
                    data[2] = (Byte.SIZE/8);
                    data[3] = (byte) resultado;
                    return data;
                }
                if (t.obterTarefa().obterTipo()==true && (t.obterEstado()== EstadoTarefa.EM_EXECUÇAO || t.obterEstado()==EstadoTarefa.ATRIBUIDA)){
                    int resultado = 2;
                    data[0] = VERSION;
                    data[2] = (Byte.SIZE/8);
                    data[3] = (byte) resultado;
                    return data;
                }
            }

        }
        if(pedido.obterEstadoPedido() == EstadoPedido.EM_RESOLUCAO) {
            List<InfoTarefa> tarefas;
            tarefas = pedido.obterListaTarefas();
            for (InfoTarefa t : tarefas) {
                if (t.obterTarefa().obterTipo() == false && t.obterEstado() == EstadoTarefa.TERMINADA) {
                    pedido.mudarEstadoPedido(EstadoPedido.CONCLUIDO);
                    int resultado = 6;
                    data[0] = VERSION;
                    data[2] = (Byte.SIZE/8);
                    data[3] = (byte) resultado;
                    return data;
                }
                if (t.obterTarefa().obterTipo() == false && (t.obterEstado() == EstadoTarefa.EM_EXECUÇAO || t.obterEstado() == EstadoTarefa.ATRIBUIDA)) {
                    int resultado = 5;
                    data[0] = VERSION;
                    data[2] = (Byte.SIZE/8);
                    data[3] = (byte) resultado;
                    return data;
                }
            }
        }
        if(pedido.obterEstadoPedido() == EstadoPedido.SUBMETIDO) {
            int resultado = 1;
            data[0] = VERSION;
            data[2] = (Byte.SIZE/8);
            data[3] = (byte) resultado;
            return data;
        }
        return null;
    }

    public byte[] numeroTarefasPendentesColaborador(int numeroColaborador){
        byte[] data = new byte[300];
        int numeroTarefas = ttc.numTarefasPendentesDoColab(numeroColaborador);
        data[0] = VERSION;
        data[1] = NUMERO_TAREFAS_PENDENTES;
        data[2] = (Byte.SIZE/8);
        data[3] = (byte) numeroTarefas;
        return data;
    }

    public byte[] numeroTarefasDepoisPrazo(int numeroColaborador){
        byte[] data = new byte[300];
        int numeroTarefas = ttc.numTarefasDpsPrazo(numeroColaborador);
        data[0] = VERSION;
        data[1] = NUMERO_TAREFAS_DEPOIS_PRAZO;
        data[2] = (Byte.SIZE/8);
        data[3] = (byte) numeroTarefas;
        return data;
    }

    public byte[] numeroTarefasEmMenosDeUmDia(int numeroColaborador){
        byte[] data = new byte[300];
        int numeroTarefas = ttc.numTarefasTerminamEmMenos1Dia(numeroColaborador);
        data[0] = VERSION;
        data[1] = NUMERO_TAREFAS_EM_MENOS_DE_UM_DIA;
        data[2] = (Byte.SIZE/8);
        data[3] = (byte) numeroTarefas;
        return data;
    }

    public byte[] listaTarefasUrgenciaCriticidade(int numeroColaborador){
        byte[] data = new byte[300];
        String finalString = "";
        List<InfoTarefa> tarefas = ttc.listarTarefasPorUrgenciaECriticidade(numeroColaborador);
        for (int i = 0; i < tarefas.size(); i++){
            if(i != (tarefas.size()-1)) {
                int id = tarefas.get(i).obterId();
                String idString = String.valueOf(id);
                idString += ",";
                finalString += idString;
            } else {
                int id = tarefas.get(i).obterId();
                String idString = String.valueOf(id);
                finalString += idString;
            }
        }
        int tamanho = finalString.length();
        data[0] = VERSION;
        data[1] = LISTA_TAREFAS_URGENCIA_CRITICIDADE;
        data[2] = (byte) tamanho;
        byte[] string = finalString.getBytes();
        for(int i=3, j=0; j < string.length; i++, j++){
            data[i] = string[j];
        }
        return data;
    }
}
