package eapli.base.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;

public class Icone implements ValueObject, Serializable, Comparable<Icone> {
    private String icone;

    @Override
    public int compareTo(Icone o) {
        return 0;
    }
}
