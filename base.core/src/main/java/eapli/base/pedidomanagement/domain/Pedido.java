package eapli.base.pedidomanagement.domain;

import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.tarefamanagement.domain.Tarefa;
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Formulario> formularios = new ArrayList<>();

    @OneToOne
    private Workflow workflow;

    @OneToMany
    @JoinColumn
    private List<Tarefa> tarefas = new ArrayList<>();

    protected Pedido(){}

    public Pedido(Date dataLimite,String urgencia,int numeroS, int numeroD,int feedback){
        this.ano=c.getTime().getYear();
        this.dataSolicitacao=c.getTime();
        this.dataLimite=dataLimite;
        //this.dataFim=null;
        if(urgencia.equals("reduzida"))
            this.urgencia=Urgencia.REDUZIDA;
        if(urgencia.equals("moderada"))
            this.urgencia=Urgencia.MODERADA;
        if(urgencia.equals("urgente"))
            this.urgencia=Urgencia.URGENTE;
        this.estadoPedido=EstadoPedido.EM_APROVACAO;
        NumeroParaPedido numeros = new NumeroParaPedido(numeroS, numeroD);
        this.numeroS = numeros.numeroSolicitante();
        this.numeroD = numeros.numeroDestinatario();
        this.feedback=new Feedback(feedback);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return null;
    }
}
