package eapli.base.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;

public class Motivo implements ValueObject, Serializable, Comparable<Motivo> {
    private String motivo;

    @Override
    public int compareTo(Motivo o) {
        return 0;
    }
}
