package eapli.base.colaboradormanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PerfilColaborador implements ValueObject, Serializable, Comparable<PerfilColaborador> {

    private String perfil;

    public PerfilColaborador() {
    }

    public PerfilColaborador(String perfil) {
        Preconditions.nonNull(perfil);
        this.perfil = perfil;
    }

    public static PerfilColaborador valueOf(final String perfil) {
        return new PerfilColaborador(perfil);
    }

    @Override
    public int compareTo(PerfilColaborador o) {
        return 0;
    }
}
