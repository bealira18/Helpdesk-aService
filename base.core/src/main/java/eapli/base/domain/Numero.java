package eapli.base.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;

public class Numero implements ValueObject, Serializable, Comparable<Numero> {

    private int numero;

    protected Numero(){}

    public Numero(int numero){
        this.numero=numero;
    }

    public int Numero(){
        return this.numero;
    }

    @Override
    public int compareTo(Numero n) {
        return 0;
    }

    @Override
    public String toString() {
        return "numero= "+numero;
    }
}
