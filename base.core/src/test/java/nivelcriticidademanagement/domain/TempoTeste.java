package nivelcriticidademanagement.domain;

import eapli.base.nivelcriticidademanagement.domain.Tempo;
import org.junit.Test;

public class TempoTeste {

    @Test(expected = IllegalArgumentException.class)
    public void regraTempo1() {
        Tempo t1=new Tempo(-5, 10, 15, 20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void regraTempo2() {
        Tempo t2=new Tempo(0, 5, -10, 15);
    }

}
