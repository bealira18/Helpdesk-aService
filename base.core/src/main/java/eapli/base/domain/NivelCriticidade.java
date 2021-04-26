package eapli.base.domain;

import eapli.framework.domain.model.AggregateRoot;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NivelCriticidade implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String objetivo;
    private Tempo tempoMedioA;
    private Tempo tempoMaximoA;
    private Tempo tempoMedioR;
    private Tempo tempoMaximoR;
    private Valor valor;
    private Etiqueta etiqueta;

    protected NivelCriticidade() {
    }

    public NivelCriticidade(String objetivo, int tempoMaximoA, int tempoMaximoR, int valor, String etiqueta) {
        this.objetivo = objetivo;
        this.tempoMedioA = new Tempo(0);
        this.tempoMaximoA = new Tempo(tempoMaximoA);
        this.tempoMedioR = new Tempo(0);
        this.tempoMaximoR = new Tempo(tempoMaximoR);
        this.valor= new Valor(valor);
        this.etiqueta= new Etiqueta(etiqueta);

    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return null;
    }
}
