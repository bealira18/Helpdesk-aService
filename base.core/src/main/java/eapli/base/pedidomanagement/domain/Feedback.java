package eapli.base.pedidomanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Feedback implements ValueObject, Serializable, Comparable<Feedback> {

    private int feedback;

    public Feedback(){}

    public Feedback(int feedback){
        this.feedback=feedback;
    }

    @Override
    public String toString() {
        return "Feedback= "+feedback;
    }

    @Override
    public int compareTo(Feedback o) {
        return 0;
    }
}
