package eapli.base.catalogomanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DescricaoCompleta implements ValueObject, Serializable, Comparable<DescricaoCompleta>{

    private String descricaoCompleta;

    public DescricaoCompleta(){}

    public DescricaoCompleta(String descricaoCompleta){
        Preconditions.nonNull(descricaoCompleta);
        if(descricaoCompleta.toCharArray().length>200)
            throw new IllegalArgumentException("Descricao muito grande");
        if(descricaoCompleta.toCharArray().length<10)
            throw new IllegalArgumentException("Descricao muito pequena");
        this.descricaoCompleta=descricaoCompleta;
    }

    public static DescricaoCompleta valueOf(final String descricaoCompleta) {
        return new DescricaoCompleta(descricaoCompleta);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DescricaoCompleta)) return false;
        DescricaoCompleta that = (DescricaoCompleta) o;
        return Objects.equals(descricaoCompleta, that.descricaoCompleta);
    }

    @Override
    public int hashCode() {
        return this.descricaoCompleta.hashCode();
    }

    @Override
    public int compareTo(DescricaoCompleta o) {
        return this.descricaoCompleta.compareTo(o.descricaoCompleta);
    }

    @Override
    public String toString() {
        return "Descricao Completa: "+descricaoCompleta;
    }

}
