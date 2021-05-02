package colaboradormanagement.domain;

import eapli.base.colaboradormanagement.domain.Contacto;
import eapli.base.colaboradormanagement.domain.Email;
import org.junit.Test;

public class EmailTeste {

    @Test(expected = IllegalArgumentException.class)
    public void regraEmail1() {
        Email email=new Email("ola");
    }

    @Test(expected = IllegalArgumentException.class)
    public void regraEmail2() {
        Email email=new Email("ola.");
    }

}
