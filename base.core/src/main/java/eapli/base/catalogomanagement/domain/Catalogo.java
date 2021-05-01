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
    private String titulo;
    private String descricaoBreve;
    private String descricaoCompleta;
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
        this.titulo=titulo;
        this.descricaoBreve=descricaoBreve;
        this.descricaoCompleta=descricaoCompleta;
        this.numero=new Numero(numero);
        this.icone=new Icone(icone);
        this.ativo=true;
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
