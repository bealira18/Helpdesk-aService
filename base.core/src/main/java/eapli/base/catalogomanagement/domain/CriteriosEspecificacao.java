package eapli.base.catalogomanagement.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class CriteriosEspecificacao implements Serializable, AggregateRoot<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idCatalogo;

    public CriteriosEspecificacao (){

    }

    public CriteriosEspecificacao(int idCatalogo){
        this.idCatalogo = idCatalogo;
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
