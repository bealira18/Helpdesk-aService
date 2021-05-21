package eapli.base.tarefamanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import java.io.Serializable;
import java.util.Date;

public class TarefaAutomatica extends Tarefa implements AggregateRoot<Integer>, Serializable {

    //SCRIPT
    
    public TarefaAutomatica() {
    }

    public TarefaAutomatica(Date dataLimite, int tempo, int prioridade) {
        super(dataLimite, tempo, prioridade);
    }

}
