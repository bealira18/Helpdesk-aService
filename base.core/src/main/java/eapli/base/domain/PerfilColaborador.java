package eapli.base.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;

public class PerfilColaborador implements ValueObject, Serializable, Comparable<PerfilColaborador>{
    private String perfil;

    @Override
    public int compareTo(PerfilColaborador o) {
        return 0;
    }
}
