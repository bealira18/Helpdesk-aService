package eapli.base.domain;

import eapli.framework.domain.model.AggregateRoot;

import java.io.Serializable;

public class NivelCriticidade implements AggregateRoot<Integer>, Serializable {

    private String objetivo;
    private int tempoMedioA;
    private int tempoMaximoA;
    private int tempoMedioR;
    private int tempoMaximoR;

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return null;
    }
}
