package eapli.base.nivelcriticidademanagement.domain;

import eapli.base.colaboradormanagement.domain.Contacto;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

@Embeddable
public class Valor implements ValueObject, Serializable, Comparable<Valor> {

    private int valor;

    public Valor(){
    }

    public Valor(int valor) {
        Preconditions.nonNull(valor);
        Preconditions.nonNegative(valor);
        this.valor = valor;
    }

    public static Valor valueOf(final int valor) {
        return new Valor(valor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Valor)) return false;
        Valor valor1 = (Valor) o;
        return valor == valor1.valor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public String toString() {
        return "Valor= " + valor;
    }
    
    @Override
    public int compareTo(Valor o) {
        if(this.valor==o.valor)
            return 0;
        else if(this.valor>o.valor){
            return 1;
        }
        return -1;
    }
}
