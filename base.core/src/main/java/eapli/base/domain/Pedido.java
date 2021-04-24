package eapli.base.domain;

import eapli.framework.domain.model.AggregateRoot;

import java.io.Serializable;
import java.util.Date;

public class Pedido implements AggregateRoot<Integer>, Serializable {

    private int ano;
    private Date dataSolicitacao;
    private Date dataLimite;
    private Date dataFim;

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return null;
    }
}
