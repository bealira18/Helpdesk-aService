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
    private int numeroS;
    private int numeroD;

    protected Rascunho(){}

    public Rascunho(Date dataLimite,String urgencia,int numeroS,int numeroD){
        this.dataLimite = dataLimite;
        if(urgencia.equals("reduzida"))
            this.urgencia=Urgencia.REDUZIDA;
        if(urgencia.equals("moderada"))
            this.urgencia=Urgencia.MODERADA;
        if(urgencia.equals("urgente"))
            this.urgencia=Urgencia.URGENTE;
        this.estadoPedido = EstadoPedido.NAO_SUBMETIDO;
        NumeroParaPedido numeros = new NumeroParaPedido(numeroS, numeroD);
        this.numeroS = numeros.numeroSolicitante();
        this.numeroD = numeros.numeroDestinatario();
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
