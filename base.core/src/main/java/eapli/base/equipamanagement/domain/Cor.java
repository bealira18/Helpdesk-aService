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
        if(!verificaCor(cor))
            throw new IllegalArgumentException("Cor inválida");
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
    
      public boolean verificaCor(String cor){

        Pattern pattern = Pattern.compile("#[a-z0-9]{6}");
        Matcher mat = pattern.matcher(cor);

        if(mat.matches())
            return true;
        else
            return false;

    }
}
