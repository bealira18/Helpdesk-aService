package eapli.base.domain;

import eapli.framework.domain.model.AggregateRoot;

import java.io.Serializable;

public class Equipa implements AggregateRoot<Integer>, Serializable {

    private String acronimo;
    private String designacao;


    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return null;
    }
}
