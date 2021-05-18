package eapli.base.servicomanagement.domain;

import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
public class Workflow implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idServico;
    private int posicao;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Tarefa> tarefas = new ArrayList<>();

    @Transient
    private HashMap<Integer,Tarefa> prioridades= new HashMap<>();

    protected Workflow(){}

    public Workflow(int idServico, int idTarefa, int posicao){
        this.idServico = idServico;
        this.posicao = posicao;
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
