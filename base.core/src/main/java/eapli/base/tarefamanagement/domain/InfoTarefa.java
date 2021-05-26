package eapli.base.tarefamanagement.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class InfoTarefa implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date dataLimite;

    private int tempoDecorridoA;
    private int tempoDecorridoR;
    private int prioridade; //prioridade

    @OneToOne
    private Tarefa tarefa;

    public InfoTarefa(){}

    public InfoTarefa(Date dataLimite,int prioridade){
        this.dataLimite=dataLimite;
        this.prioridade=prioridade;
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
