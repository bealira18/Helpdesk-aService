package eapli.base.equipamanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Cor implements ValueObject, Serializable, Comparable<Cor> {

    private String cor;

    protected Cor(){}

    public Cor(String cor){
        this.cor = cor;
    }

    @Override
    public int compareTo(Cor o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Cor{" +
                "cor='" + cor + '\'' +
                '}';
    }
}
