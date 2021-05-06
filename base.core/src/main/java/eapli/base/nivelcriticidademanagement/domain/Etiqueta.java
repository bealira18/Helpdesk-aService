package eapli.base.nivelcriticidademanagement.domain;

import eapli.base.colaboradormanagement.domain.Contacto;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

@Embeddable
public class Etiqueta implements ValueObject, Serializable, Comparable<Etiqueta> {

    private String etiqueta;

    public Etiqueta(){
    }

    public Etiqueta(String etiqueta) {
        Preconditions.nonNull(etiqueta);
        if (etiqueta.toCharArray().length > 25) {
            throw new IllegalArgumentException("Etiqueta inválida");
        }
        this.etiqueta = etiqueta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etiqueta etiqueta1 = (Etiqueta) o;
        return etiqueta.equals(etiqueta1.etiqueta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(etiqueta);
    }

    @Override
    public int compareTo(Etiqueta o) {
        return 0;
    }
}