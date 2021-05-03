package catalogomanagement.domain;

import eapli.base.catalogomanagement.domain.DescricaoBreve;
import eapli.base.catalogomanagement.domain.DescricaoCompleta;
import org.junit.Test;

public class DescricaoCompletaTeste {

    @Test(expected = IllegalArgumentException.class)
    public void regraDescricaoCompleta1() {
        DescricaoCompleta descricaoCompleta=new DescricaoCompleta(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void regraDescricaoCompleta2() {
        DescricaoCompleta descricaoCompleta=new DescricaoCompleta("descricao muito pequena");
    }

}
