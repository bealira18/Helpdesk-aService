package eapli.base.catalogomanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DescricaoBreve implements ValueObject, Serializable, Comparable<DescricaoBreve>{

    private String desricaoBreve;

    public DescricaoBreve(){}

    public DescricaoBreve(String desricaoBreve){
        Preconditions.nonNull(desricaoBreve);
        if(desricaoBreve.toCharArray().length>20)
            throw new IllegalArgumentException("Descricao muito grande");
        this.desricaoBreve=desricaoBreve;
    }

    public static DescricaoBreve valueOf(final String desricaoBreve) {
        return new DescricaoBreve(desricaoBreve);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DescricaoBreve)) return false;
        DescricaoBreve that = (DescricaoBreve) o;
        return Objects.equals(desricaoBreve, that.desricaoBreve);
    }

    @Override
    public int hashCode() {
        return this.desricaoBreve.hashCode();
    }

    @Override
    public int compareTo(DescricaoBreve o) {
        return this.desricaoBreve.compareTo(o.desricaoBreve);
    }

    @Override
    public String toString() {
        return "Descricao Breve: "+desricaoBreve;
    }

}
