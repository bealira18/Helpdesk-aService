package eapli.base.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class Prioridade implements ValueObject, Serializable, Comparable<Prioridade> {

    private int prioridade;

    public Prioridade(){}
    
    public Prioridade(int prioridade){
        this.prioridade=prioridade;
    }

    @Override
    public String toString() {
        return "Prioridade= " + prioridade;
    }
    
    @Override
    public int compareTo(Prioridade o) {
        return 0;
    }
}
