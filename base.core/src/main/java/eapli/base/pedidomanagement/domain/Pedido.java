package eapli.base.pedidomanagement.domain;

import eapli.base.formulariomanagement.domain.RespostasFormulario;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
public class Pedido implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int ano;
    @Temporal(TemporalType.DATE)
    private Date dataSolicitacao;
    @Temporal(TemporalType.DATE)
    private Date dataLimite;
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    private Urgencia urgencia;
    private EstadoPedido estadoPedido;
    private Feedback feedback;
    private int numeroS;
    private int numeroD;
    @Transient
    Calendar c = Calendar.getInstance();

    @OneToOne(cascade = CascadeType.ALL)
    private Servico servico;

    @OneToOne
    private Rascunho rascunho;

    @OneToOne
    private RespostasFormulario respostasFormulario;

    @OneToOne
    private Workflow workflow;

    @OneToMany
    @JoinColumn(name="PedidoId")
    private List<InfoTarefa> tarefas = new ArrayList<>();

    public Pedido(){}

    public Pedido(Date dataLimite,String urgencia,int numeroS/*, int numeroD*/){
        this.ano=c.getTime().getYear();
        this.dataSolicitacao=c.getTime();
        this.dataLimite=dataLimite;
        //this.dataFim=null;
        if(urgencia.equals("r"))
            this.urgencia=Urgencia.REDUZIDA;
        if(urgencia.equals("m"))
            this.urgencia=Urgencia.MODERADA;
        if(urgencia.equals("u"))
            this.urgencia=Urgencia.URGENTE;
        this.estadoPedido=EstadoPedido.SUBMETIDO;
        NumeroParaPedido numeros = new NumeroParaPedido(numeroS, numeroD);
        this.numeroS = numeros.numeroSolicitante();
        this.numeroD = numeros.numeroSolicitante();
        this.feedback=new Feedback(-1);
    }

    public Servico obterServico() {
        return servico;
    }

    public void associarServico(Servico servico) {
        this.servico = servico;
    }

    public void associarWorkflow(Workflow workflow){
        this.workflow = workflow;
    }

    public Date obterDataLimite() {
        return dataLimite;
    }

    public Urgencia obterUrgencia() {
        return urgencia;
    }

    public int obterId(){
        return id;
    }

    public List<InfoTarefa> obterListaTarefas(){
        return tarefas;
    }

    public EstadoPedido obterEstadoPedido(){
        return estadoPedido;
    }

    public int obterNumeroS() {
        return numeroS;
    }

    public void darFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public void mudarEstadoPedido(EstadoPedido e){
        this.estadoPedido = e;
    }
    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return null;
    }

    public Date obterDataSolicitacao() {
        return dataSolicitacao;
    }

    public Date obterDataFim() {
        return dataFim;
    }

    public void mudarDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public String toString() {
        return "Id= " + id +
                ", dataSolicitacao= " + dataSolicitacao +
                ", urgencia= " + urgencia +
                ", estadoPedido= " + estadoPedido +
                ", servico= " + servico.obterTitulo();
    }
}
