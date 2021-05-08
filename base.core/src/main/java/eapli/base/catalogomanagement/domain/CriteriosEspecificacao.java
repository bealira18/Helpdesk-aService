package eapli.base.catalogomanagement.domain;

import eapli.base.equipamanagement.domain.Equipa;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class CriteriosEspecificacao implements Serializable, AggregateRoot<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idCatalogo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Equipa> equipas = new ArrayList<>();

    public CriteriosEspecificacao() {

    }

    public CriteriosEspecificacao(int idCatalogo) {
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

    public int obterIdCatalogo() {
        return this.idCatalogo;
    }

    public void mudarIdCatalogo(int idCatalogo) {
        this.idCatalogo = idCatalogo;
    }
}
