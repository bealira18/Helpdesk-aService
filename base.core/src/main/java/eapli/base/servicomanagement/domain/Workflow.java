package eapli.base.servicomanagement.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Workflow implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idServico;
    private int idTarefa;
    private int posicao;

    protected Workflow(){}

    public Workflow(int idServico, int idTarefa, int posicao){
        this.idServico = idServico;
        this.idTarefa = idTarefa;
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
