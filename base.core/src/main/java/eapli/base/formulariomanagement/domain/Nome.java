package eapli.base.formulariomanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Nome implements ValueObject, Serializable, Comparable<Nome>{

    private String nome;

    protected Nome(){}

    public Nome(final String nome){
        Preconditions.nonNull(nome);
        if(nome.toCharArray().length>50)
            throw new IllegalArgumentException("Nome muito extenso");
        this.nome=nome;
    }

    public static Nome valueOf(final String nome) {
        return new Nome(nome);
    }

    public String obterNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nome)) return false;
        Nome that = (Nome) o;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return this.nome.hashCode();
    }

    @Override
    public String toString() {
        return "Nome= " + nome;
    }

    @Override
    public int compareTo(Nome o) {
        return this.nome.compareTo(o.nome);
    }

}
