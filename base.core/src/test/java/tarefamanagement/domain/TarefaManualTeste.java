package tarefamanagement.domain;

import eapli.base.tarefamanagement.domain.TarefaManual;
import java.util.Date;
import org.junit.Test;

public class TarefaManualTeste {

    @Test(expected = IllegalArgumentException.class)
    public void nullEmTodosParametros() {

        Date d2 = new Date(null);

        TarefaManual instance = new TarefaManual(d2, 0, 0);
    }

}
