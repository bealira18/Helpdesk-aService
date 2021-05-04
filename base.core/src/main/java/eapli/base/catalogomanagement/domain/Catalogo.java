package eapli.base.catalogomanagement.domain;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.nivelcriticidademanagement.domain.NivelCriticidade;
import eapli.base.servicomanagement.domain.Servico;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Catalogo implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Titulo titulo;
    private DescricaoBreve descricaoBreve;
    private DescricaoCompleta descricaoCompleta;
    private boolean ativo;
    private Numero numero;
    private Icone icone;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private List<Colaborador> colaboradores = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<CriteriosEspecificacao> criterios = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Servico> servicos = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private NivelCriticidade nivelCriticidade;

    protected Catalogo(){}

    public Catalogo(String titulo,String descricaoBreve,String descricaoCompleta,int numero, String icone){
        this.titulo=new Titulo(titulo);
        this.descricaoBreve=new DescricaoBreve(descricaoBreve);
        this.descricaoCompleta=new DescricaoCompleta(descricaoCompleta);
        this.numero=new Numero(numero);
        this.icone=new Icone(icone);
        this.ativo=true;
    }

    public Titulo obterTitulo() {
        return titulo;
    }

    public void mudarTitulo(Titulo titulo) {
        this.titulo = titulo;
    }

    public void mudarDescricaoBreve(DescricaoBreve descricaoBreve) {
        this.descricaoBreve = descricaoBreve;
    }

    public void mudarDescricaoCompleta(DescricaoCompleta descricaoCompleta) {
        this.descricaoCompleta = descricaoCompleta;
    }

    public void mudarIcone(Icone icone) {
        this.icone = icone;
    }

    public void mudarColaboradorResponsavel(Numero numero) {
        this.numero = numero;
    }

    public void mudarEstado(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Catalogo:\n" +
                "id= " + id +
                "\ntitulo=" + titulo;
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
