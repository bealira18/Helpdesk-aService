package eapli.base.catalogomanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class Icone implements ValueObject, Serializable, Comparable<Icone> {
    private String icone;

    public Icone(){
    }

    public Icone(final String icone){
        if(!icone.contains(".jpg") && !icone.contains(".png") && !icone.isEmpty())
            throw new IllegalArgumentException("Formato do icone deve ser .jpg ou .png");
        this.icone=icone;
    }

    public static Icone valueOf(final String icone) {
        return new Icone(icone);
    }

    public String obterIcone(){
        return icone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Icone)) return false;
        Icone icone1 = (Icone) o;
        return Objects.equals(icone, icone1.icone);
    }

    @Override
    public int hashCode() {
        return this.icone.hashCode();
    }

    @Override
    public int compareTo(Icone o) {
        return this.icone.compareTo(o.icone);
    }

    @Override
    public String toString() {
        return "Icone= "+icone;
    }
}
