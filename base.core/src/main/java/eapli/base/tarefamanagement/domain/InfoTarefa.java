package eapli.base.tarefamanagement.domain;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Entity
public class InfoTarefa implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date dataLimite;
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    
    private EstadoTarefa estadoTarefa;
    private int tempoDecorrido;
    private int prioridade; //prioridade

    @OneToOne
    private Colaborador colaborador;

    @OneToOne
    private Tarefa tarefa;

    public InfoTarefa(){}

    public InfoTarefa(Date dataLimite,int prioridade){
        this.dataLimite=dataLimite;
        this.prioridade=prioridade;
        this.estadoTarefa = EstadoTarefa.NAO_INICIADA;
        this.dataInicio = Calendar.getInstance().getTime();
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

    public EstadoTarefa obterEstado(){
        return this.estadoTarefa;
    }

    public Date obterDataInicio(){
        return dataInicio;
    }

    public int obterTempoDecorrido() {
        return tempoDecorrido;
    }

    public Date obterDataFim(){
        return dataFim;
    }

    public void mudarEstado(EstadoTarefa estado) {
        this.estadoTarefa = estado;
    }

    public void mudarDataFim(Date dataFim){
        this.dataFim = dataFim;
    }

    public void mudarTempoDecorrido(int tempoDecorrido){
        this.tempoDecorrido = tempoDecorrido;
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
