package eapli.base.colaboradormanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Contacto implements ValueObject, Serializable, Comparable<Contacto> {
    private long contacto;

    protected Contacto(){}

    public Contacto(long contacto) {
        this.contacto = contacto;
    }

    @Override
    public int compareTo(Contacto o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Contacto: "+contacto;
    }
}
