package eapli.base.formulariomanagement.domain;

import eapli.base.nivelcriticidademanagement.domain.Etiqueta;
import eapli.framework.domain.model.AggregateRoot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Formulario implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private Etiqueta etiqueta;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Atributo> atributos = new ArrayList<>();
    
    protected Formulario(){}
    
    public Formulario(String nome, String etiqueta){
        this.nome=nome;
        this.etiqueta= new Etiqueta(etiqueta);
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
