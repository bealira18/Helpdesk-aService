package eapli.base.catalogomanagement.domain;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CriteriosEspecificacao implements Serializable, AggregateRoot<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean ativo;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private List<Equipa> equipas = new ArrayList<>();

    public CriteriosEspecificacao() {
        this.ativo=true;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return null;
    }

    public int obterId(){
        return id;
    }

    public void addEquipa(Equipa equipa){
        equipas.add(equipa);
    }

    public void removerEquipa(Equipa equipa){
        equipas.remove(equipa);
    }

    public List<Equipa> equipas() {
        return equipas;
    }
    
     public void mudarEstado(Boolean ativo){
        this.ativo = ativo;
    }
}
