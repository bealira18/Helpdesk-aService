package eapli.base.pedidomanagement.domain;

import eapli.base.colaboradormanagement.domain.Numero;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

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

    protected Pedido(){}

    public Pedido(Date dataLimite,String urgencia,int feedback,int numero){
        this.ano=c.getTime().getYear();
        this.dataSolicitacao=c.getTime();
        this.dataLimite=dataLimite;
        this.dataFim=null;
        this.urgencia=new Urgencia(urgencia);
        this.estadoPedido=new EstadoPedido("em aprovação");
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
