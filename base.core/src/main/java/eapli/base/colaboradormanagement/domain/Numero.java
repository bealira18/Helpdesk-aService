package eapli.base.colaboradormanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Numero implements ValueObject, Serializable, Comparable<Numero> {

    private int numero;

    public Numero(){
    }

    public Numero(int numero) {
        Preconditions.nonNull(numero);
        Preconditions.nonNegative(numero);
        this.numero = numero;
    }

    public static Numero valueOf(final int numero) {
        return new Numero(numero);
    }

    public int obterNumero(){
        return numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Numero)) return false;
        Numero numero1 = (Numero) o;
        return numero == numero1.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public int compareTo(Numero n) {
        if(this.numero==n.numero)
            return 0;
        else if(this.numero>n.numero){
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "numero= "+numero;
    }

}
