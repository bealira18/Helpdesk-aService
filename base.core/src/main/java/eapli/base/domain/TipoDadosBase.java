package eapli.base.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;

public class TipoDadosBase implements ValueObject, Serializable, Comparable<TipoDadosBase> {

    private String tipoDadosBase;

    @Override
    public int compareTo(TipoDadosBase o) {
        return 0;
    }
}
