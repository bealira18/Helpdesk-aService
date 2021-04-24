package eapli.base.domain;

import eapli.framework.domain.model.AggregateRoot;

import java.io.Serializable;
import java.util.Date;

public class Tarefa implements AggregateRoot<Integer>, Serializable {

    private Date dataLimite;
    private int tempoDecorridoA;
    private int tempoDecorridoR;

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return null;
    }
}
