package eapli.base.formulariomanagement.domain;

import eapli.base.catalogomanagement.domain.Icone;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TipoDadosBase implements ValueObject, Serializable, Comparable<TipoDadosBase> {

    private String tipoDadosBase;

    public TipoDadosBase(){
    }

    public TipoDadosBase(final String tipoDadosBase){
        Preconditions.nonNull(tipoDadosBase);
        //if(!tipoDadosBase.equals("String") || !tipoDadosBase.equals("Integer") || !tipoDadosBase.equals("Char") || !tipoDadosBase.equals("Boolean") || !tipoDadosBase.equals("Short") || !tipoDadosBase.equals("Double") || !tipoDadosBase.equals("Float"))
        //    throw new IllegalArgumentException("Formato inválido");
        this.tipoDadosBase=tipoDadosBase;
    }

    public static TipoDadosBase valueOf(final String tipoDadosBase) {
        return new TipoDadosBase(tipoDadosBase);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoDadosBase)) return false;
        TipoDadosBase that = (TipoDadosBase) o;
        return Objects.equals(tipoDadosBase, that.tipoDadosBase);
    }

    @Override
    public int hashCode() {
        return this.tipoDadosBase.hashCode();
    }

    @Override
    public String toString() {
        return "TipoDadosBase= " + tipoDadosBase;
    }

    @Override
    public int compareTo(TipoDadosBase o) {
        return this.tipoDadosBase.compareTo(o.tipoDadosBase);
    }
}
