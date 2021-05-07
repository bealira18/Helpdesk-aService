package formulariomanagement.domain;

import eapli.base.formulariomanagement.domain.Nome;
import org.junit.Test;

public class NomeTeste {

    @Test(expected = IllegalArgumentException.class)
    public void regraNome11() {
        Nome nome=new Nome(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void regraNome2() {
        Nome nome=new Nome("demasiados caracteres para ser um nome, por isso vai dar erro e pedir nova introdução");
    }

}
