package eapli.base.formulariomanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ExpressaoRegular implements ValueObject, Serializable, Comparable<ExpressaoRegular>{

    private String expressaoRegular;

    protected ExpressaoRegular(){}

    public ExpressaoRegular(final String expressaoRegular){
        if(expressaoRegular.toCharArray().length>50)
            throw new IllegalArgumentException("Expressao Regular muito extensa");
        this.expressaoRegular=expressaoRegular;
    }

    public static ExpressaoRegular valueOf(final String expressaoRegular) {
        return new ExpressaoRegular(expressaoRegular);
    }

    public String obterExpressaoRegular() {
        return expressaoRegular;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExpressaoRegular)) return false;
        ExpressaoRegular that = (ExpressaoRegular) o;
        return Objects.equals(expressaoRegular, that.expressaoRegular);
    }

    @Override
    public int hashCode() {
        return this.expressaoRegular.hashCode();
    }

    @Override
    public String toString() {
        return "Expressao regular= " + expressaoRegular;
    }

    @Override
    public int compareTo(ExpressaoRegular o) {
        return this.expressaoRegular.compareTo(o.expressaoRegular);
    }

}
