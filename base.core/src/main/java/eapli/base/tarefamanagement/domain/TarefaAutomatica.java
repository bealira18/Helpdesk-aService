package eapli.base.tarefamanagement.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class TarefaAutomatica extends Tarefa implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //SCRIPT
    
    public TarefaAutomatica() {
    }

    public TarefaAutomatica(Date dataLimite, int tempo, int prioridade) {
        super(dataLimite, tempo, prioridade);
    }

}
