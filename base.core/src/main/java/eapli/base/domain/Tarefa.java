package eapli.base.domain;

import eapli.framework.domain.model.AggregateRoot;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Tarefa implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date dataLimite;
    private int tempoDecorridoA;
    private int tempoDecorridoR;
    private EstadoTarefa estadoTarefa;
    private int tempo; //Tempo
    private Prioridade prioridade;
    
    protected Tarefa(){}
    
    public Tarefa(Date dataLimite, int tempoDecorridoA,int tempoDecorridoR,String estadoTarefa, int tempo, int prioridade){
        this.dataLimite=dataLimite;
        this.tempoDecorridoA=tempoDecorridoA;
        this.tempoDecorridoR=tempoDecorridoR;
        this.estadoTarefa=new EstadoTarefa(estadoTarefa);
        Tempo t=new Tempo(0,0,0,tempo);
        this.tempo= t.getTempoMaximoR();
        this.prioridade=new Prioridade(3);
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
