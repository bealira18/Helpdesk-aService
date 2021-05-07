package eapli.base.equipamanagement.domain;

import eapli.base.formulariomanagement.domain.Nome;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class TipoEquipa implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique=true)
    private Nome nome;
    private Descricao descricao;
    private Cor cor;

    protected TipoEquipa(){}

    public TipoEquipa(String nome,String descricao, String cor){
        this.nome=new Nome(nome);
        this.descricao = new Descricao(descricao);
        this.cor = new Cor(cor);
    }

    public int obterId() {
        return id;
    }

    public void mudarNome(Nome nome) {
        this.nome = nome;
    }

    public void mudarDescricao(Descricao descricao) {
        this.descricao = descricao;
    }

    public void mudarCor(Cor cor) {
        this.cor = cor;
    }

    public int compareTo(String nome) {
        return this.nome.obterNome().compareTo(nome);
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
