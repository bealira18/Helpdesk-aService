package eapli.base.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;

public class EstadoPedido implements ValueObject, Serializable, Comparable<EstadoPedido> {

    private String estadoPedido;

    @Override
    public int compareTo(EstadoPedido o) {
        return 0;
    }
}
