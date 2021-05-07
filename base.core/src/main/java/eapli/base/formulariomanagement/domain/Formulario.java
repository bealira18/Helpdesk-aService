package eapli.base.formulariomanagement.domain;

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
    private Nome nome;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Atributo> atributos = new ArrayList<>();
    
    protected Formulario(){}
    
    public Formulario(String nome){
        this.nome=new Nome(nome);
    }

    public int compareTo(String nome) {
        return this.nome.obterNome().compareTo(nome);
    }

    public void addAtributo(Atributo atributo){
        atributos.add(atributo);
    }

    public void removeAtributo(Atributo atributo){
        atributos.remove(atributo);
    }

    public void mudarNome(Nome nome) {
        this.nome = nome;
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
