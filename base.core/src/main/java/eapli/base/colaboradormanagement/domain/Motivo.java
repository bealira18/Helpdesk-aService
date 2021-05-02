package eapli.base.colaboradormanagement.domain;

import eapli.base.catalogomanagement.domain.Icone;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Motivo implements ValueObject, Serializable, Comparable<Motivo> {
    private String motivo;

    protected Motivo(){
    }

    public Motivo(final String motivo){
        Preconditions.nonNull(motivo);
        this.motivo=motivo;
    }

    public static Motivo valueOf(final String motivo) {
        return new Motivo(motivo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Motivo)) return false;
        Motivo motivo1 = (Motivo) o;
        return Objects.equals(motivo, motivo1.motivo);
    }

    @Override
    public int hashCode() {
        return this.motivo.hashCode();
    }

    @Override
    public int compareTo(Motivo o) {
        return this.motivo.compareTo(o.motivo);
    }

    @Override
    public String toString() {
        return "Motivo: "+motivo;
    }
}
