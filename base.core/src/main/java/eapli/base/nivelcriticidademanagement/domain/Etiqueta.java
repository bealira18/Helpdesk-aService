package eapli.base.nivelcriticidademanagement.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class Etiqueta implements ValueObject, Serializable, Comparable<Etiqueta> {

    private String etiqueta;
    
    public Etiqueta(){}
    
    public Etiqueta(String etiqueta){
        this.etiqueta=etiqueta;
    }

    @Override
    public String toString() {
        return "Etiqueta= " + etiqueta ;
    }
    

    
    @Override
    public int compareTo(Etiqueta o) {
        return 0;
    }
}
