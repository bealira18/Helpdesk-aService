package eapli.base.nivelcriticidademanagement.domain;

import eapli.base.servicomanagement.domain.Servico;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.framework.domain.model.AggregateRoot;

import java.io.Serializable;
import javax.persistence.*;

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
    private Valor valor; //valor de 1 a 5, em que o 1 é o mais "urgente" (?)
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

    public String obterObjetivo(){
        return objetivo;
    }

    public Valor obterValor(){
        return valor;
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
