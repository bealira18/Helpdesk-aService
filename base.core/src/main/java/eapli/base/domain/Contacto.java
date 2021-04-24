package eapli.base.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;

public class Contacto implements ValueObject, Serializable, Comparable<Contacto> {
    private long contacto;

    @Override
    public int compareTo(Contacto o) {
        return 0;
    }
}
