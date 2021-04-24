package eapli.base.domain;

import eapli.framework.domain.model.AggregateRoot;

import java.io.Serializable;

public class Servico implements AggregateRoot<Integer>, Serializable {

    private String titulo;
    private String descricaoBreve;
    private String descricaoCompleta;
    private String palavrasChave;
    private boolean requerFeedback;
    private boolean requerAprovacao;
    private boolean Aprovado;
    private boolean automatico;
    private boolean completo;


    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return null;
    }
}
