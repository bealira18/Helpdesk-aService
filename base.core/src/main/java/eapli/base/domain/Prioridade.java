package eapli.base.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;

public class Prioridade implements ValueObject, Serializable, Comparable<Prioridade> {

    private int prioridade;

    @Override
    public int compareTo(Prioridade o) {
        return 0;
    }
}
