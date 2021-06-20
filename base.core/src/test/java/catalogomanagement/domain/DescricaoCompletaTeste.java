package catalogomanagement.domain;

import eapli.base.catalogomanagement.domain.DescricaoCompleta;
import org.junit.Test;

public class DescricaoCompletaTeste {

    @Test(expected = IllegalArgumentException.class)
    public void testeAssegurarDescricaoCompletaNaoNull() {
        DescricaoCompleta descricaoCompleta=new DescricaoCompleta(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeVerficarDescricaoCompletaDemasiadoPequena() {
        DescricaoCompleta descricaoCompleta=new DescricaoCompleta("pequena");
    }

}
