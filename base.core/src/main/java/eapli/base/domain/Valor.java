package eapli.base.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class Valor implements ValueObject, Serializable, Comparable<Valor> {

    private int valor;

    public Valor(){}
    
    public Valor(int valor){
        this.valor=valor;
    }

    @Override
    public String toString() {
        return "Valor= " + valor;
    }
    
    
    
    @Override
    public int compareTo(Valor o) {
        return 0;
    }
}
