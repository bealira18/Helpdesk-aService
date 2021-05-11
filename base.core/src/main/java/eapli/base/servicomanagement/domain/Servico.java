package eapli.base.servicomanagement.domain;

import eapli.base.catalogomanagement.domain.Icone;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.nivelcriticidademanagement.domain.NivelCriticidade;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Servico implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique=true)
    private String titulo;
    private String descricaoBreve;
    private String descricaoCompleta;
    private String palavrasChave;
    @Transient
    private boolean requerFeedback;
    @Transient
    private boolean requerAprovacao;
    @Transient
    private boolean Aprovado;
    @Transient
    private boolean automatico;
    private boolean completo = false;
    private Icone icone;
    private boolean ativo = false;
    private boolean apresentar = false;

    @OneToOne
    private NivelCriticidade nivelCriticidade;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Formulario> formularios = new ArrayList<>();

    @OneToOne
    private Workflow workflow;

    protected Servico() {
    }

    public Servico(String titulo, String descricaoBreve, String descricaoCompleta, String palavrasChave, String icone) {
        Preconditions.nonNull(titulo);
        this.titulo = titulo;
        this.descricaoBreve = descricaoBreve;
        this.descricaoCompleta = descricaoCompleta;
        this.palavrasChave = palavrasChave;
        this.icone = new Icone(icone);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return null;
    }

    public String obterTitulo() {
        return this.titulo;
    }

    public String obterDescricaoBreve(){
        return descricaoBreve;
    }

    public String obterDescricaoCompleta(){
        return descricaoCompleta;
    }

    public String obterPalavrasChave(){
        return palavrasChave;
    }

    public Icone obterIcone(){
        return icone;
    }

    public boolean obterApresentar(){
        return apresentar;
    }

    public boolean estaCompleto() {
        return completo;
    }

    public boolean estaAtivo() {
        return ativo;
    }

    public void mudarApresentar(boolean apresentar){
        this.apresentar = apresentar;
    }

    public void mudarTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void mudarDescricaoBreve(String descricaoBreve) {
        this.descricaoBreve = descricaoBreve;
    }

    public void mudarDescricaoCompleta(String descricaoCompleta) {
        this.descricaoCompleta = descricaoCompleta;
    }

    public void mudarPalavrasChave(String palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    public void mudarIcone(Icone icone) {
        this.icone = icone;
    }
    
    public void mudarEstado(boolean ativo) {
        this.ativo = ativo;
    }

    public void mudarCompleto(boolean completo){
        this.completo = completo;
    }

    public int compareTo(String titulo) {
        return this.titulo.compareTo(titulo);
    }

    @Override
    public String toString() {
        return "Servico:\n" +
                "titulo= " + titulo +
                "\ndescricaoBreve= " + descricaoBreve +
                "\npalavrasChave= " + palavrasChave;
    }
}
