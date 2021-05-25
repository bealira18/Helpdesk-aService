package eapli.base.formulariomanagement.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class RespostasFormulario implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String resposta;

    @OneToOne
    private Atributo atributo;

    @OneToOne
    private Formulario formulario;

    public RespostasFormulario(){}

    public RespostasFormulario(String resposta){
        this.resposta=resposta;
    }

    public void relacionarAtributo(Atributo atributo) {
        this.atributo = atributo;
    }

    public void relacionarFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return null;
    }

    @Override
    public String toString() {
        return "Atributo: "+atributo.obterNome()
                +"Resposta: "+resposta;
    }
}
