package eapli.base.equipamanagement.domain;

import eapli.base.catalogomanagement.domain.CriteriosEspecificacao;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Equipa implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Acronimo acronimo;
    private Designacao designacao;

    @ManyToMany(mappedBy = "", cascade = CascadeType.ALL)
    @JoinTable
    private List<Colaborador> colaboradores = new ArrayList<>();

    @OneToOne
    private CriteriosEspecificacao criteriosEspecificacao;

    @OneToOne
    private TipoEquipa tipoEquipa;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Tarefa> tarefas = new ArrayList<>();

    protected Equipa() {
    }

    public Equipa(String acronimo, String designacao) {
        this.acronimo = new Acronimo(acronimo);
        this.designacao = new Designacao(designacao);
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
