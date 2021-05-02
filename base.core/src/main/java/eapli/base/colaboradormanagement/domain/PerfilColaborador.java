package eapli.base.colaboradormanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PerfilColaborador implements Serializable, AggregateRoot<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String perfil;

    protected PerfilColaborador(){}

    public PerfilColaborador(String perfil) {
        this.perfil = perfil;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return null;
    }
}
