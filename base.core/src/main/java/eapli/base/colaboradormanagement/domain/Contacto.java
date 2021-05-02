package eapli.base.colaboradormanagement.domain;

import eapli.base.catalogomanagement.domain.Icone;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Contacto implements ValueObject, Serializable, Comparable<Contacto> {
    private long contacto;

    protected Contacto(){
    }

    public Contacto(long contacto) {
        Preconditions.nonNull(contacto);
        Preconditions.nonNegative(contacto);
        this.contacto = contacto;
    }

    public static Contacto valueOf(final Long contacto) {
        return new Contacto(contacto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contacto)) return false;
        Contacto contacto1 = (Contacto) o;
        return contacto == contacto1.contacto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(contacto);
    }

    @Override
    public int compareTo(Contacto o) {
        if(this.contacto==o.contacto)
            return 0;
        else if(this.contacto>o.contacto){
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Contacto: "+contacto;
    }
}
