package eapli.base.catalogomanagement.domain;

import eapli.base.colaboradormanagement.domain.Email;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Titulo implements ValueObject, Serializable, Comparable<Titulo>{

    private String titulo;

    public Titulo(){}

    public Titulo(String titulo){
        Preconditions.nonNull(titulo);
        this.titulo=titulo;
    }

    public static Titulo valueOf(final String titulo) {
        return new Titulo(titulo);
    }

    public String obterTitulo(){
        return titulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Titulo)) return false;
        Titulo titulo1 = (Titulo) o;
        return Objects.equals(titulo, titulo1.titulo);
    }

    @Override
    public int hashCode() {
        return this.titulo.hashCode();
    }

    @Override
    public int compareTo(Titulo o) {
        return this.titulo.compareTo(o.titulo);
    }

    @Override
    public String toString() {
        return "Titulo: "+titulo;
    }

}
