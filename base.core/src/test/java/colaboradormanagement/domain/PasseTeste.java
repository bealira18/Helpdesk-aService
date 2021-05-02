package colaboradormanagement.domain;

import eapli.base.colaboradormanagement.domain.Passe;
import org.junit.Test;

public class PasseTeste {

    @Test(expected = IllegalArgumentException.class)
    public void regraPasse1() {
        Passe passe=new Passe("ola");
    }

    @Test(expected = IllegalArgumentException.class)
    public void regraPasse2() {
        Passe passe=new Passe("Ola1");
    }

}
