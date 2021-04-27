package eapli.base.domain;

import eapli.framework.domain.model.AggregateRoot;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Formulario implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private Etiqueta etiqueta;
    
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
