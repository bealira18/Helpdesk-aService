package eapli.base.equipamanagement.domain;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Equipa implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String acronimo;
    private String designacao;

    @ManyToMany(mappedBy = "", cascade = CascadeType.ALL)
    @JoinTable
    private List<Colaborador> colaboradores = new ArrayList<>();

    protected Equipa(){}

    public Equipa(String acronimo,String designacao){
        this.acronimo=acronimo;
        this.designacao=designacao;
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
