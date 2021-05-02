package eapli.base.pedidomanagement.domain;

import eapli.base.colaboradormanagement.domain.Contacto;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Feedback implements ValueObject, Serializable, Comparable<Feedback> {

    private int feedback;

    public Feedback(){
    }

    public Feedback(int feedback) {
        Preconditions.nonNull(feedback);
        Preconditions.nonNegative(feedback);
        if(feedback>5)
            throw new IllegalArgumentException("Numero fora do limite");
        this.feedback = feedback;
    }

    public static Feedback valueOf(final int feedback) {
        return new Feedback(feedback);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Feedback)) return false;
        Feedback feedback1 = (Feedback) o;
        return feedback == feedback1.feedback;
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedback);
    }

    @Override
    public String toString() {
        return "Feedback= "+feedback;
    }

    @Override
    public int compareTo(Feedback o) {
        if(this.feedback==o.feedback)
            return 0;
        else if(this.feedback>o.feedback){
            return 1;
        }
        return -1;
    }
}
