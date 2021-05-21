package eapli.base.tarefamanagement.domain;

import eapli.base.colaboradormanagement.domain.Contacto;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

@Embeddable
public class Prioridade implements ValueObject, Serializable, Comparable<Prioridade> {

    private int prioridade;

    public Prioridade(){}

    public Prioridade(int prioridade) {
        Preconditions.nonNegative(prioridade);
        if(prioridade>5)
            throw new IllegalArgumentException("Prioridade fora do limite");
        this.prioridade = prioridade;
    }

    public static Prioridade valueOf(final int prioridade) {
        return new Prioridade(prioridade);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prioridade)) return false;
        Prioridade that = (Prioridade) o;
        return prioridade == that.prioridade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prioridade);
    }

    @Override
    public String toString() {
        return "Prioridade= " + prioridade;
    }
    
    @Override
    public int compareTo(Prioridade o) {
        if(this.prioridade==o.prioridade)
        return 0;
        else if(this.prioridade>o.prioridade){
            return 1;
        }
        return -1;
    }
}
