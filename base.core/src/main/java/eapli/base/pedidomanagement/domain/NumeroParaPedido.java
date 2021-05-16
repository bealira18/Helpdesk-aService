package eapli.base.pedidomanagement.domain;

import eapli.base.catalogomanagement.domain.Icone;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

@Embeddable
public class NumeroParaPedido implements ValueObject, Serializable, Comparable<NumeroParaPedido> {

    private int solicitante;
    private int destinatario;

    public NumeroParaPedido() {
    }

    public NumeroParaPedido(int numeroS, int numeroD) {
        //Preconditions.nonNull(numeroS);
        //Preconditions.nonNull(numeroD);
        Preconditions.nonNegative(numeroS);
        Preconditions.nonNegative(numeroD);
        this.destinatario = numeroD;
        this.solicitante = numeroS;
    }

    public int numeroSolicitante(){
        return solicitante;
    }

    public int numeroDestinatario(){
        return destinatario;
    }

    @Override
    public int compareTo(NumeroParaPedido o) {
        return 0;
    }
}
