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
    //private Nome nome;
    private String nome;
    private boolean completo = false;
    private boolean ativo = false;
    private int numAtributos;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Atributo> atributos = new ArrayList<>();
    
    public Formulario(){}
    
    public Formulario(String nome){
        this.nome=nome;
    }

    public int compareTo(String nome) {
        return this.nome.compareTo(nome);
    }

    public void addAtributo(Atributo atributo){
        atributos.add(atributo);
    }

    public void removeAtributo(Atributo atributo){
        atributos.remove(atributo);
    }

    public int obterId() {
        return id;
    }

    public void mudarNome(String nome) {
        this.nome = nome;
    }

    public boolean estaCompleto() {
        return completo;
    }

    public boolean estaAtivo() {
        return ativo;
    }

    public void mudarCompleto(boolean completo) {
        this.completo = completo;
    }

    public void mudarAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String obterNome() {
        return nome;
    }

    public List<Atributo> obterAtributos() {
        return atributos;
    }

    public void mudarNumAtributos(int numAtributos) {
        this.numAtributos = numAtributos;
    }

    public int obterNumAtributos() {
        return numAtributos;
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
