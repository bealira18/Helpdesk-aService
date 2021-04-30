package eapli.base.equipamanagement.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class TipoEquipa implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descricao;
    private Cor cor;

    protected TipoEquipa(){}

    public TipoEquipa(String descricao, String cor){
        this.descricao = descricao;
        this.cor = new Cor(cor);
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
