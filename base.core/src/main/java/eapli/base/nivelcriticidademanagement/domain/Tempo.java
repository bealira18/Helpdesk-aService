package eapli.base.nivelcriticidademanagement.domain;

import eapli.base.catalogomanagement.domain.Icone;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

@Embeddable
public class Tempo implements ValueObject, Serializable, Comparable<Tempo> {

    private int tempoMedioA;
    private int tempoMedioR;
    private int tempoMaximoA;
    private int tempoMaximoR;

    public Tempo() {
    }

    public Tempo(final int tempoMedioA,final int tempoMaximoA,final int tempoMedioR,final int tempoMaximoR){
        Preconditions.nonNull(tempoMedioA);
        Preconditions.nonNull(tempoMedioR);
        Preconditions.nonNull(tempoMaximoA);
        Preconditions.nonNull(tempoMaximoR);
        this.tempoMedioA=tempoMedioA;
        this.tempoMaximoA=tempoMaximoA;
        this.tempoMedioR=tempoMedioR;
        this.tempoMaximoR=tempoMaximoR;
    }

    public void setTempoMedioA(int tempoMedioA) {
        this.tempoMedioA = tempoMedioA;
    }

    public void setTempoMedioR(int tempoMedioR) {
        this.tempoMedioR = tempoMedioR;
    }

    public void setTempoMaximoA(int tempoMaximoA) {
        this.tempoMaximoA = tempoMaximoA;
    }

    public void setTempoMaximoR(int tempoMaximoR) {
        this.tempoMaximoR = tempoMaximoR;
    }

    public int getTempoMedioA() {
        return tempoMedioA;
    }

    public int getTempoMedioR() {
        return tempoMedioR;
    }

    public int getTempoMaximoA() {
        return tempoMaximoA;
    }

    public int getTempoMaximoR() {
        return tempoMaximoR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tempo)) return false;
        Tempo tempo = (Tempo) o;
        return getTempoMedioA() == tempo.getTempoMedioA() && getTempoMedioR() == tempo.getTempoMedioR() && getTempoMaximoA() == tempo.getTempoMaximoA() && getTempoMaximoR() == tempo.getTempoMaximoR();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTempoMedioA(), getTempoMedioR(), getTempoMaximoA(), getTempoMaximoR());
    }

    @Override
    public String toString() {
        return "Tempo Medio A= " + tempoMedioA +
                "Tempo Medio R= " + tempoMedioR +
                "Tempo Maximo A= " + tempoMaximoA +
                "Tempo Maximo R= " + tempoMaximoR;
    }

    @Override
    public int compareTo(Tempo o) {
        if(this.tempoMedioR==o.tempoMedioR &&
                this.tempoMedioA==o.tempoMedioA &&
                this.tempoMaximoR==o.tempoMaximoR &&
                this.tempoMaximoA==o.tempoMaximoA)
            return 0;
        else if(this.tempoMedioR>o.tempoMedioR &&
                this.tempoMedioA>o.tempoMedioA &&
                this.tempoMaximoR>o.tempoMaximoR &&
                this.tempoMaximoA>o.tempoMaximoA){
            return 1;
        }
        return -1;
    }
}
