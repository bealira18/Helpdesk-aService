package eapli.base.pedidomanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Urgencia implements ValueObject, Serializable, Comparable<Urgencia> {

    private String urgencia;

    public Urgencia(){}

    public Urgencia(String urgencia){
        this.urgencia=urgencia;
    }

    @Override
    public String toString() {
        return "Urgencia= "+urgencia;
    }

    @Override
    public int compareTo(Urgencia o) {
        return 0;
    }
}
