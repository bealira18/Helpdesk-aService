package eapli.base.equipamanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class Cor implements ValueObject, Serializable, Comparable<Cor> {

    private String cor;

    protected Cor(){}

    public Cor(final String cor){
        Preconditions.nonNull(cor);
        this.cor=cor;
    }

    @Override
    public int compareTo(Cor o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Cor= " + cor;
    }

}
