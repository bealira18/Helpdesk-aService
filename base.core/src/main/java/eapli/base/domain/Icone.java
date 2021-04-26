package eapli.base.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Icone implements ValueObject, Serializable, Comparable<Icone> {
    private String icone;

    public Icone(){}

    public Icone(String icone){
        this.icone=icone;
    }

    @Override
    public int compareTo(Icone o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Icone= "+icone;
    }
}
