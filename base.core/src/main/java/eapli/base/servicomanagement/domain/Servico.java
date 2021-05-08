package eapli.base.servicomanagement.domain;

import eapli.base.catalogomanagement.domain.Icone;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.nivelcriticidademanagement.domain.NivelCriticidade;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Servico implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
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
    private boolean completo;
    private Icone icone;

    @OneToOne
    private NivelCriticidade nivelCriticidade;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Formulario> formularios = new ArrayList<>();

    @OneToOne
    private Workflow workflow;

    protected Servico(){}

    public Servico(String titulo,String descricaoBreve,String descricaoCompleta,String palavrasChave,String icone){
        this.titulo=titulo;
        this.descricaoBreve=descricaoBreve;
        this.descricaoCompleta=descricaoCompleta;
        this.palavrasChave=palavrasChave;
        this.icone=new Icone(icone);
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
