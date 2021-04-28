package eapli.base.pedidomanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EstadoPedido implements ValueObject, Serializable, Comparable<EstadoPedido> {

    private String estadoPedido;

    public EstadoPedido(){}

    public EstadoPedido (String estadoPedido){
        this.estadoPedido=estadoPedido;
    }

    @Override
    public String toString() {
        return "EstadoPedido= "+estadoPedido;
    }

    @Override
    public int compareTo(EstadoPedido o) {
        return 0;
    }
}
