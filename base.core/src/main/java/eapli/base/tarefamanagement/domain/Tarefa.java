package eapli.base.tarefamanagement.domain;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.nivelcriticidademanagement.domain.NivelCriticidade;
import eapli.base.nivelcriticidademanagement.domain.Tempo;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.framework.domain.model.AggregateRoot;
import org.hibernate.annotations.JoinColumnOrFormula;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Tarefa implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descricao;
    private int tempoMedioA;
    private int tempoMedioR;
    private int tempoMedio;
    private boolean aprovacao;//true se a tarefa for de aprovaçao, false se for de realizaçao
    private int aprovado = 0; //se for igual 1 foi aprovado, se for igual a -1 rejeitado

    public Tarefa() {
    }

    public Tarefa(String descricao,boolean aprovacao) {
        this.descricao = descricao;
        this.aprovacao = aprovacao;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return null;
    }

    public int obterId() {
        return this.id;
    }

    public boolean obterTipo(){
        return this.aprovacao;
    }

    public int obterAprovado(){
        return aprovado;
    }

    public String obterDescricao() {
        return descricao;
    }

    public void atualizarTempoMedioA(int tempoMedioA) {
        this.tempoMedioA = tempoMedioA;
    }

    public void atualizarTempoMedioR(int tempoMedioR) {
        this.tempoMedioR = tempoMedioR;
    }

    public int obterTempoMedio(){
        return tempoMedio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarefa)) return false;
        Tarefa tarefa = (Tarefa) o;
        return id == tarefa.id;
    }

}
