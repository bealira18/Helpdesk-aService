package eapli.base.domain;

import eapli.framework.domain.model.AggregateRoot;

import java.io.Serializable;

public class Formulario implements AggregateRoot<Integer>, Serializable {

    private String nome;

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return null;
    }
}
