package nivelcriticidademanagement.domain;

import eapli.base.nivelcriticidademanagement.domain.Valor;
import org.junit.Test;

public class ValorTeste {

    @Test(expected = IllegalArgumentException.class)
    public void regraValor1() {
        Valor v1=new Valor(-1);
    }
}
