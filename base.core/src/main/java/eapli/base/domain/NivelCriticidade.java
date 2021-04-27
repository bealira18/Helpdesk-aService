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
    private int tempoMedioA;
    private int tempoMaximoA;
    private int tempoMedioR;
    private int tempoMaximoR;
    private Valor valor;
    private Etiqueta etiqueta;

    protected NivelCriticidade() {
    }

    public NivelCriticidade(String objetivo, int tempoMaximoA, int tempoMaximoR, int valor, String etiqueta) {
        this.objetivo = objetivo;
        Tempo t=new Tempo(0,tempoMaximoA,0,tempoMaximoR);
        this.tempoMedioA = t.getTempoMedioA();
        this.tempoMaximoA = t.getTempoMaximoA();
        this.tempoMedioR = t.getTempoMedioR();
        this.tempoMaximoR = t.getTempoMaximoR();
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
