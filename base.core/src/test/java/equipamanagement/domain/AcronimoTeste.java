package equipamanagement.domain;

import eapli.base.equipamanagement.domain.Acronimo;
import org.junit.Test;

public class AcronimoTeste {
   
       @Test(expected = IllegalArgumentException.class)
    public void regraAcronimo() {
        Acronimo acronimo=new Acronimo(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void regraAcronimo2() {
        Acronimo acronimo=new Acronimo("aaaa");
    }
}
