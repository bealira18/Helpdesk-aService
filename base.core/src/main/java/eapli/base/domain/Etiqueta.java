package eapli.base.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;

public class Etiqueta implements ValueObject, Serializable, Comparable<Etiqueta> {

    private String etiqueta;

    @Override
    public int compareTo(Etiqueta o) {
        return 0;
    }
}
