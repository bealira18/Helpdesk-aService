package eapli.base.formulariomanagement.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Atributo implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String descricao;
    private String expressaoRegular;
    private TipoDadosBase tipoDadosBase;

    protected Atributo(){}

    public Atributo(String nome, String descricao, String expressaoRegular, String tipoDadosBase){
        this.nome = nome;
        this.descricao = descricao;
        this.expressaoRegular = expressaoRegular;
        this.tipoDadosBase = new TipoDadosBase(tipoDadosBase);
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
