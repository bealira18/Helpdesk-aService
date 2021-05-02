package eapli.base.pedidomanagement.domain;

import eapli.base.colaboradormanagement.domain.Numero;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Rascunho implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;
    @Temporal(TemporalType.DATE)
    private Date dataLimite;
    private Urgencia urgencia;
    private EstadoPedido estadoPedido;
    private Feedback feedback;
    private Numero numero;

    protected Rascunho(){}

    public Rascunho(Date dataLimite, String urgencia, String estadoPedido, int feedback, int numero){
        this.dataLimite = dataLimite;
        this.urgencia = Urgencia.REDUZIDA;
        this.estadoPedido = null;
        this.feedback = new Feedback(feedback);
        this.numero = new Numero(numero);
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
