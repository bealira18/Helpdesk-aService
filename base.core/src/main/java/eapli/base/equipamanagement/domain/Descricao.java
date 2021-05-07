package eapli.base.equipamanagement.domain;

import eapli.base.formulariomanagement.domain.Nome;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
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

    public static Descricao valueOf(final String descricao) {
        return new Descricao(descricao);
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
