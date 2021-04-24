package eapli.base.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;

public class Funcao implements ValueObject, Serializable, Comparable<Funcao>{
    private String funcao;

    @Override
    public int compareTo(Funcao o) {
        return 0;
    }
}
