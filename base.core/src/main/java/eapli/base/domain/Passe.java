package eapli.base.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;

public class Passe implements ValueObject, Serializable, Comparable<Passe>{
    private String passe;

    @Override
    public int compareTo(Passe o) {
        return 0;
    }
}
