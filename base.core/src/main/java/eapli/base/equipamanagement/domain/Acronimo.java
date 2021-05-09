package eapli.base.equipamanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class Acronimo implements ValueObject, Serializable, Comparable<Acronimo> {
   
    private String acronimo;

    protected Acronimo(){}

    public Acronimo(final String acronimo){
        Preconditions.nonNull(acronimo);
        if(!verificaAcronimo(acronimo))
            throw new IllegalArgumentException("Acrónimo inválido");
        this.acronimo=acronimo;
    }

    public String obterAcronimo() {
        return acronimo;
    }

    @Override
    public int compareTo(Acronimo o) {
        return this.acronimo.compareTo(o.acronimo);
    }

    @Override
    public String toString() {
        return "Acronimo= " + acronimo;
    }
    
      public boolean verificaAcronimo(String acronimo){

        Pattern pattern = Pattern.compile("[A-Z]+");
        Matcher mat = pattern.matcher(acronimo);

        if(mat.matches())
            return true;
        else
            return false;

    }

    public String stringAcronimo(){
        return acronimo;
    }
}
