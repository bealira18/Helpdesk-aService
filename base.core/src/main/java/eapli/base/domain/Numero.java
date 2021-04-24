package eapli.base.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;

public class Numero implements ValueObject, Serializable, Comparable<Numero> {

    private int numero;

    @Override
    public int compareTo(Numero n) {
        return 0;
    }
}
