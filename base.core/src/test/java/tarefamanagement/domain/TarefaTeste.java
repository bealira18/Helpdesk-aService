package tarefamanagement.domain;

import eapli.base.tarefamanagement.domain.Tarefa;
import java.util.Date;
import org.junit.Test;

public class TarefaTeste {
    
     @Test(expected = IllegalArgumentException.class)
    public void nullEmTodosParametros() {
        Tarefa instance = new Tarefa(new Date(null),0,0,null,0,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullNumParametro() {
        Tarefa instance=new Tarefa(new Date(null),2,4,"string",5,6);
        Tarefa instance2=new Tarefa(new Date(5),2,4,null,5,6);
    }
    
}
