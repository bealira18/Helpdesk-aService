package eapli.base.tarefamanagement.domain;

import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.nivelcriticidademanagement.domain.Tempo;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.framework.domain.model.AggregateRoot;
import org.hibernate.annotations.JoinColumnOrFormula;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Pedido pedido;

    @OneToOne
    private Formulario formulario;

    @ManyToOne
    @JoinColumn
    private Workflow workflow;
    
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
