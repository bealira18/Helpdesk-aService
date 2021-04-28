package eapli.base.colaboradormanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Passe implements ValueObject, Serializable, Comparable<Passe>{

    private String passe;

    protected Passe(){}

    public Passe(String passe) {
        this.passe = passe;
    }

    @Override
    public int compareTo(Passe o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Passe: "+passe;
    }
}
