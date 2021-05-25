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

    @Temporal(TemporalType.DATE)
    private Date dataLimite;

    private int tempoDecorridoA;
    private int tempoDecorridoR;
    private int tempo; //Tempo
    private int prioridade; //prioridade
    private boolean aprovacao; //true se a tarefa for de aprovaçao, false se for de realizaçao

    /*@OneToOne
    @JoinColumn
    private Workflow workflow;*/
    @OneToOne
    private NivelCriticidade nivelCriticidade;

    @ManyToOne
    private Colaborador colaborador;

    public Tarefa() {
    }

    public Tarefa(boolean aprovacao) {
        this.aprovacao = aprovacao;
    }

    public Tarefa(Date dataLimite, int tempo, int prioridade) {
        this.dataLimite = dataLimite;
        this.tempoDecorridoA = 0;
        this.tempoDecorridoR = 0;
        this.tempo=tempo;
        //Tempo t=new Tempo(0,0,0,tempo);
        this.prioridade = /*new Prioridade(prioridade);*/ prioridade;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return null;
    }

    public void atualizarTempoAprovacao(int tempo) {
        this.tempoDecorridoA = tempo;
    }

    public void atualizarTempoRealizacao(int tempo) {
        this.tempoDecorridoR = tempo;
    }

    public Colaborador obterColaborador() {
        return this.colaborador;
    }

    public void associarColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public int obterId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarefa)) return false;
        Tarefa tarefa = (Tarefa) o;
        return id == tarefa.id;
    }

}
