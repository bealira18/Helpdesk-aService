package eapli.base.tarefamanagement.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
public class ExecutorTarefas implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private boolean ocupado;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Executor_Tarefas_id")
    private List<InfoTarefa> tarefas = new ArrayList<>();

    public ExecutorTarefas(){}

    public ExecutorTarefas(String nome){
        this.nome  = nome;
        this.ocupado = false;
    }

    public int obterId(){
        return this.id;
    }

    public boolean obterOcupado(){
        return this.ocupado;
    }

    public void mudarOcupado(boolean ocupado){
        this.ocupado = ocupado;
    }

    public String obterNome(){
        return this.nome;
    }

    public List<InfoTarefa> tarefas(){
        return this.tarefas;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return null;
    }

    public void reivindicarTarefa(InfoTarefa tarefa){
        tarefas.add(tarefa);
    }
}
