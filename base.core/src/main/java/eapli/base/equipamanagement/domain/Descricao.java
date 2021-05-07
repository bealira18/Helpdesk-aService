package eapli.base.equipamanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import java.io.Serializable;

public class Descricao implements ValueObject, Serializable, Comparable<Descricao>{

    private String descricao;

    protected Descricao(){}

    public Descricao(final String descricao) {
        Preconditions.nonNull(descricao);
        if (descricao.toCharArray().length > 50) {
            throw new IllegalArgumentException("Descrição inválida");
        }
        this.descricao = descricao;
    }

    @Override
    public int compareTo(Descricao o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Descrição= " + descricao;
    }

}
