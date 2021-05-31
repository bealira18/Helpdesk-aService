package eapli.base.tarefamanagement.domain;

import eapli.base.colaboradormanagement.domain.Colaborador;
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
    private Colaborador colaborador;

    @OneToOne
    private Tarefa tarefa;

    public InfoTarefa(){}

    public InfoTarefa(Date dataLimite,int prioridade){
        this.dataLimite=dataLimite;
        this.prioridade=prioridade;
    }

    public Colaborador obterColaborador() {
        return this.colaborador;
    }

    public int obterIdColaborador(){
        return this.colaborador.obterNumero().obterNumero();
    }

    public void associarColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public void associarTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public Date obterDataLimite(){
        return this.dataLimite;
    }

    public int obterPrioridade(){
        return this.prioridade;
    }

    public int obteridTarefa(){return this.tarefa.obterId();}

    public int obterId() {
        return id;
    }

    public Tarefa obterTarefa() {
        return tarefa;
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
