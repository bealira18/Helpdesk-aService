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
    private boolean valido;

    @OneToOne
    private Atributo atributo;

    public RespostasFormulario(){}

    public RespostasFormulario(String resposta){
        this.resposta=resposta;
    }

    public String obterResposta() {
        return resposta;
    }

    public void relacionarAtributo(Atributo atributo) {
        this.atributo = atributo;
    }

    public void mudarValido(boolean valido) {
        this.valido = valido;
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
