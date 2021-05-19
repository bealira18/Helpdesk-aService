package eapli.base.formulariomanagement.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Atributo implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique=true)
    private String nome;
    private String etiqueta;
    private String descricao;
    private ExpressaoRegular expressaoRegular;
    private TipoDadosBase tipoDadosBase;
    private boolean completo = false;
    private boolean ativo = false;

    public Atributo(){}

    public Atributo(String nome, String etiqueta, String descricao, String expressaoRegular, String tipoDadosBase){
        this.nome =nome;
        this.etiqueta=etiqueta;
        this.descricao =descricao;
        this.expressaoRegular = new ExpressaoRegular(expressaoRegular);
        this.tipoDadosBase = new TipoDadosBase(tipoDadosBase);
    }

    public void mudarNome(String nome) {
        this.nome = nome;
    }

    public void mudarEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public void mudarDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void mudarExpressaoRegular(ExpressaoRegular expressaoRegular) {
        this.expressaoRegular = expressaoRegular;
    }

    public void mudarTipoDadosBase(TipoDadosBase tipoDadosBase) {
        this.tipoDadosBase = tipoDadosBase;
    }

    public void mudarCompleto(boolean completo) {
        this.completo = completo;
    }

    public void mudarAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int obterId() {
        return id;
    }

    public String obterNome() {
        return nome;
    }

    public String obterEtiqueta() {
        return etiqueta;
    }

    public String obterDescricao() {
        return descricao;
    }

    public ExpressaoRegular obterExpressaoRegular() {
        return expressaoRegular;
    }

    public TipoDadosBase obterTipoDadosBase() {
        return tipoDadosBase;
    }

    public boolean obterCompleto() {
        return completo;
    }

    public int compareTo(String nome) {
        return this.nome.compareTo(nome);
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
