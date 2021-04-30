package eapli.base.pedidomanagement.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Historico implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idPedido;

    protected Historico(){
    }

    public Historico(int idPedido){
        this.idPedido = idPedido;
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
