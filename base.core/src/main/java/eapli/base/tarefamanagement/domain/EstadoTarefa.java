package eapli.base.tarefamanagement.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class EstadoTarefa implements ValueObject, Serializable, Comparable<EstadoTarefa> {

    private String estadoTarefa;
    
    public EstadoTarefa(){}
    
    public EstadoTarefa(String estadoTarefa){
        this.estadoTarefa=estadoTarefa;
    }

    @Override
    public String toString() {
        return "EstadoTarefa= " + estadoTarefa;
    }

    
    
    @Override
    public int compareTo(EstadoTarefa o) {
        return 0;
    }
}
