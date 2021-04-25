package eapli.base.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PerfilColaborador implements ValueObject, Serializable, Comparable<PerfilColaborador>{
    private String perfil;

    protected PerfilColaborador(){}

    public PerfilColaborador(String perfil) {
        this.perfil = perfil;
    }

    @Override
    public int compareTo(PerfilColaborador o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Perfil: "+perfil;
    }
}
