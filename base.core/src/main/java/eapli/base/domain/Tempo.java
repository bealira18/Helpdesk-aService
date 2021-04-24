package eapli.base.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;

public class Tempo implements ValueObject, Serializable, Comparable<Tempo> {

    private int tempo;

    @Override
    public int compareTo(Tempo o) {
        return 0;
    }
}
