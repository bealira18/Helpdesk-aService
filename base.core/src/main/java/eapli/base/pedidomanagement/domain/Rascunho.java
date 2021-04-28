package eapli.base.pedidomanagement.domain;

import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.pedidomanagement.domain.EstadoPedido;
import eapli.base.pedidomanagement.domain.Feedback;
import eapli.base.pedidomanagement.domain.Urgencia;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

public class Rascunho implements Serializable {

    @Temporal(TemporalType.DATE)
    private Date dataLimite;
    private Urgencia urgencia;
    private EstadoPedido estadoPedido;
    private Feedback feedback;
    private Numero numero;

    protected Rascunho(){}

    public Rascunho(Date dataLimite, String urgencia, String estadoPedido, int feedback, int numero){
        this.dataLimite = dataLimite;
        this.urgencia = new Urgencia(urgencia);
        this.estadoPedido = new EstadoPedido(estadoPedido);
        this.feedback = new Feedback(feedback);
        this.numero = new Numero(numero);
    }
}
