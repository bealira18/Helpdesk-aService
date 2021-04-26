package eapli.base.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class Tempo implements ValueObject, Serializable, Comparable<Tempo> {

    private int tempo;

    public Tempo() {
    }

    public Tempo(int tempo) {
        this.tempo = tempo;
    }

    @Override
    public String toString() {
        return "Tempo= " + tempo;
    }

    @Override
    public int compareTo(Tempo o) {
        return 0;
    }
}
