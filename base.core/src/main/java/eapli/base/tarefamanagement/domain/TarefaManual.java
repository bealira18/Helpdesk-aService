package eapli.base.tarefamanagement.domain;

import eapli.base.formulariomanagement.domain.Formulario;
import eapli.framework.domain.model.AggregateRoot;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class TarefaManual extends Tarefa implements AggregateRoot<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Formulario formulario;

    public TarefaManual() {
    }

    public TarefaManual(boolean aprovacao){
        super(aprovacao);
    }

    public TarefaManual(Date dataLimite, int tempo, int prioridade) {
        super(dataLimite, tempo, prioridade);
    }

    public void addFormulario(Formulario f){
        this.formulario=f;
    }

    public Formulario obterFormulario() {
        return formulario;
    }

    public int obterId() {
        return id;
    }

    @Override
    public String toString() {
        return "id= "+id;
    }
}
