package eapli.base.equipamanagement.domain;

import eapli.base.formulariomanagement.domain.Nome;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class TipoEquipa implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Nome nome;
    private String descricao;
    private Cor cor;

    protected TipoEquipa(){}

    public TipoEquipa(String nome,String descricao, String cor){
        this.nome=new Nome(nome);
        this.descricao = descricao;
        this.cor = new Cor(cor);
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
