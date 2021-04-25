package eapli.base.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Numero implements ValueObject, Serializable, Comparable<Numero> {

    private int numero;

    protected Numero(){}

    public Numero(int numero){
        this.numero=numero;
    }

    @Override
    public int compareTo(Numero n) {
        return 0;
    }

    @Override
    public String toString() {
        return "numero= "+numero;
    }
}
