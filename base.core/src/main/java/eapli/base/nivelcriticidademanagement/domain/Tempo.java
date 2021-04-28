package eapli.base.nivelcriticidademanagement.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class Tempo implements ValueObject, Serializable, Comparable<Tempo> {

    private int tempoMedioA;
    private int tempoMedioR;
    private int tempoMaximoA;
    private int tempoMaximoR;

    public Tempo() {
    }

    public Tempo(int tempoMedioA,int tempoMaximoA,int tempoMedioR,int tempoMaximoR){
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
    public String toString() {
        return "Tempo Medio A= " + tempoMedioA;
    }

    @Override
    public int compareTo(Tempo o) {
        return 0;
    }
}
