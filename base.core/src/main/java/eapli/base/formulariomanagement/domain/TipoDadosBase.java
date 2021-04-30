package eapli.base.formulariomanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TipoDadosBase implements ValueObject, Serializable, Comparable<TipoDadosBase> {

    private String tipoDadosBase;

    public TipoDadosBase(){}

    public TipoDadosBase(String tipoDadosBase){
        this.tipoDadosBase = tipoDadosBase;
    }

    @Override
    public String toString() {
        return "TipoDadosBase{" +
                "tipoDadosBase='" + tipoDadosBase + '\'' +
                '}';
    }

    @Override
    public int compareTo(TipoDadosBase o) {
        return 0;
    }
}
