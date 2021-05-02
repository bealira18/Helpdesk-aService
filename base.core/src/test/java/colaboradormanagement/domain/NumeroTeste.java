package colaboradormanagement.domain;

import eapli.base.colaboradormanagement.domain.Numero;
import org.junit.Test;

public class NumeroTeste {

    @Test(expected = IllegalArgumentException.class)
    public void regraNumero() {
        Numero numero=new Numero(-123);
    }

}
