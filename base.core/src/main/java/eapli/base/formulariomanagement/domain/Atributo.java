package eapli.base.formulariomanagement.domain;

import eapli.base.equipamanagement.domain.Descricao;
import eapli.base.nivelcriticidademanagement.domain.Etiqueta;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Atributo implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique=true)
    private Nome nome;
    private Etiqueta etiqueta;
    private Descricao descricao;
    private ExpressaoRegular expressaoRegular;
    private TipoDadosBase tipoDadosBase;

    protected Atributo(){}

    public Atributo(String nome, String etiqueta, String descricao, String expressaoRegular, String tipoDadosBase){
        this.nome = new Nome(nome);
        this.etiqueta=new Etiqueta(etiqueta);
        this.descricao = new Descricao(descricao);
        this.expressaoRegular = new ExpressaoRegular(expressaoRegular);
        this.tipoDadosBase = new TipoDadosBase(tipoDadosBase);
    }

    public void mudarNome(Nome nome) {
        this.nome = nome;
    }

    public void mudarEtiqueta(Etiqueta etiqueta) {
        this.etiqueta = etiqueta;
    }

    public void mudarDescricao(Descricao descricao) {
        this.descricao = descricao;
    }

    public void mudarExpressaoRegular(ExpressaoRegular expressaoRegular) {
        this.expressaoRegular = expressaoRegular;
    }

    public void mudarTipoDadosBase(TipoDadosBase tipoDadosBase) {
        this.tipoDadosBase = tipoDadosBase;
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
