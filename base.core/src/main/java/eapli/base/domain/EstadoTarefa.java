package eapli.base.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;

public class EstadoTarefa implements ValueObject, Serializable, Comparable<EstadoTarefa> {

    private String estadoTarefa;

    @Override
    public int compareTo(EstadoTarefa o) {
        return 0;
    }
}
