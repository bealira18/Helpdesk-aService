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
    private boolean completo=false;

    @OneToOne
    private Servico servico;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "WORKFLOW_ID")
    private List<Tarefa> tarefas = new ArrayList<>();

    @Transient
    private HashMap<Integer,Tarefa> prioridades= new HashMap<>();

    public Workflow(){}

    public int obterId() {
        return id;
    }

    public void associarServico(Servico s){
        this.servico=s;
    }

    public List<Tarefa> obterTarefas() {
        return tarefas;
    }

    public boolean estaCompleto() {
        return completo;
    }

    public void mudarCompleto(boolean completo) {
        this.completo = completo;
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
