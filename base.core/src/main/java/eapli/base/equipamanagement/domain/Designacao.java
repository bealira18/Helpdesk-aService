package eapli.base.equipamanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.Embeddable;

@Embeddable
public class Designacao implements ValueObject, Serializable, Comparable<Designacao> {

    private String designacao;

    protected Designacao() {
    }

    public Designacao(final String designacao) {
        Preconditions.nonNull(designacao);
        if (designacao.toCharArray().length > 50) {
            throw new IllegalArgumentException("Designação inválida");
        }
        this.designacao = designacao;
    }

    @Override
    public int compareTo(Designacao o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Designação= " + designacao;
    }

}
