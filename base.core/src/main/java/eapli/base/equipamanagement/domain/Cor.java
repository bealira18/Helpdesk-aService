package eapli.base.equipamanagement.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;

public class Cor implements ValueObject, Serializable, Comparable<Cor> {

    private String cor;

    @Override
    public int compareTo(Cor o) {
        return 0;
    }
}
