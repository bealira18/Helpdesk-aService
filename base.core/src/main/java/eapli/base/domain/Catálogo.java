package eapli.base.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;

public class Catálogo implements AggregateRoot<Integer>, Serializable {

    private String titulo;
    private String descricaoBreve;
    private String descricaoCompleta;
    private boolean ativo;


    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return null;
    }
}
