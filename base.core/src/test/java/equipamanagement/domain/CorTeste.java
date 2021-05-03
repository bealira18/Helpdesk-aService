package equipamanagement.domain;

import eapli.base.equipamanagement.domain.Cor;
import org.junit.Test;

public class CorTeste {
    
       @Test(expected = IllegalArgumentException.class)
    public void regraCor() {
        Cor cor=new Cor("naocor");
    }

    @Test(expected = IllegalArgumentException.class)
    public void regraCor2() {
        Cor cor=new Cor("#0000");
    }
}
