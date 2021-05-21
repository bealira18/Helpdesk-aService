package eapli.base.tarefamanagement.domain;

import eapli.base.formulariomanagement.domain.Formulario;
import eapli.framework.domain.model.AggregateRoot;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.OneToOne;

public class TarefaManual extends Tarefa implements AggregateRoot<Integer>, Serializable {

    @OneToOne
    private Formulario formulario;

    public TarefaManual() {
    }

    public TarefaManual(Date dataLimite, int tempo, int prioridade) {
        super(dataLimite, tempo, prioridade);
    }

}
