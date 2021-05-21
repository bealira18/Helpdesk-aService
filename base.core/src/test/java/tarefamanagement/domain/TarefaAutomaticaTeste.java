package tarefamanagement.domain;

import eapli.base.tarefamanagement.domain.TarefaAutomatica;
import java.util.Date;
import org.junit.Test;

public class TarefaAutomaticaTeste {

    @Test(expected = IllegalArgumentException.class)
    public void nullEmTodosParametros() {

        Date d2 = new Date(null);

        TarefaAutomatica instance = new TarefaAutomatica(d2, 0, 0);
    }
}
