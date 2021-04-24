package eapli.base.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;

public class Urgencia implements ValueObject, Serializable, Comparable<Urgencia> {

    private String urgencia;

    @Override
    public int compareTo(Urgencia o) {
        return 0;
    }
}
