package formulariomanagement.domain;

import eapli.base.formulariomanagement.domain.ExpressaoRegular;
import eapli.base.formulariomanagement.domain.TipoDadosBase;
import org.junit.Test;

public class TipoDadosBaseTeste {

    @Test(expected = IllegalArgumentException.class)
    public void regraTipoDadosBase1() {
        TipoDadosBase tipoDadosBase=new TipoDadosBase(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void regraTipoDadosBase2() {
        TipoDadosBase tipoDadosBase=new TipoDadosBase("qualquer coisa");
    }

}
