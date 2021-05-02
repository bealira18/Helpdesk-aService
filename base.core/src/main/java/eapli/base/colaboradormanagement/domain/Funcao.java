package eapli.base.colaboradormanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Funcao implements ValueObject, Serializable, Comparable<Funcao>{
    private String funcao;

    protected Funcao(){
    }

    public Funcao(final String funcao){
        Preconditions.nonNull(funcao);
        this.funcao=funcao;
    }

    @Override
    public int compareTo(Funcao o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Funcao: "+funcao;
    }
}
