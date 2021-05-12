package colaboradormanagement.domain;

import eapli.base.colaboradormanagement.domain.Contacto;
import org.junit.Test;

public class ContactoTeste {

    @Test(expected = IllegalArgumentException.class)
    public void regraContacto1() {
        Contacto contacto=new Contacto("123");
    }

    @Test(expected = IllegalArgumentException.class)
    public void regraContacto2() {
        Contacto contacto=new Contacto("952345678");
    }

}
