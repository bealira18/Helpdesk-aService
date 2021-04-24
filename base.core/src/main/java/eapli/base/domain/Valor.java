package eapli.base.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;

public class Valor implements ValueObject, Serializable, Comparable<Valor> {

    private int valor;

    @Override
    public int compareTo(Valor o) {
        return 0;
    }
}
