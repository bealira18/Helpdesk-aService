package eapli.base.colaboradormanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Motivo implements ValueObject, Serializable, Comparable<Motivo> {
    private String motivo;

    protected Motivo(){}

    public Motivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public int compareTo(Motivo o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Motivo: "+motivo;
    }
}
