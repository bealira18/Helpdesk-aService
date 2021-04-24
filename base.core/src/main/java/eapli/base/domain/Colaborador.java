package eapli.base.domain;

import eapli.framework.domain.model.AggregateRoot;

import java.io.Serializable;
import java.util.Date;

public class Colaborador implements AggregateRoot<Numero>, Serializable {

    private String nomeCurto;
    private String nomeCompleto;
    private Date dataNascimento;
    private String localResidencia;
    private boolean ativo;
    private boolean serHumano;

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Numero identity() {
        return null;
    }
}
