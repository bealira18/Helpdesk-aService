package eapli.base.colaboradormanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Passe implements ValueObject, Serializable, Comparable<Passe>{

    private String passe;

    protected Passe(){
    }

    public Passe(final String passe){
        Preconditions.nonNull(passe);
        if(!passeCumpreRequisitos(passe) || passe.toCharArray().length<8)
            throw new IllegalArgumentException("Passe inválida");
        this.passe=passe;
    }

    public boolean passeCumpreRequisitos(String passe){
        boolean hasDigit = false;
        boolean hasUpper = false;
        boolean hasLower = false;
        char[] chars = passe.toCharArray();
        for(char c : chars) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
            if (Character.isLowerCase(c)) {
                hasLower = true;
            }
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            }
        }
        if (hasDigit == true && hasLower == true && hasUpper == true){
            return true;
        }
        else {
            return false;
        }
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
