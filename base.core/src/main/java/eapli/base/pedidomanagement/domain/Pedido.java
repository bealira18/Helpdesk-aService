package eapli.base.pedidomanagement.domain;

import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.domain.Workflow;
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
    private Numero numero;
    Calendar c = Calendar.getInstance();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Servico> servicos = new ArrayList<>();

    @OneToOne
    private Rascunho rascunho;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Formulario> formularios = new ArrayList<>();

    @OneToOne
    private Workflow workflow;

    protected Pedido(){}

    public Pedido(Date dataLimite,String urgencia,int feedback,int numero){
        this.ano=c.getTime().getYear();
        this.dataSolicitacao=c.getTime();
        this.dataLimite=dataLimite;
        this.dataFim=null;
        this.urgencia=Urgencia.REDUZIDA;
        this.estadoPedido=EstadoPedido.EM_APROVACAO;
        this.feedback=new Feedback(feedback);
        this.numero=new Numero(numero);
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
