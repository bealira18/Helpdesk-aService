package eapli.base.catalogomanagement.domain;

import eapli.base.colaboradormanagement.domain.Numero;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

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
