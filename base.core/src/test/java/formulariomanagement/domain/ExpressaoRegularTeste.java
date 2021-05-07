package formulariomanagement.domain;

import eapli.base.formulariomanagement.domain.ExpressaoRegular;
import org.junit.Test;

public class ExpressaoRegularTeste {

    @Test(expected = IllegalArgumentException.class)
    public void regraExpressaoRegular1() {
        ExpressaoRegular expressaoRegular=new ExpressaoRegular(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void regraExpressaoRegular2() {
        ExpressaoRegular expressaoRegular=new ExpressaoRegular("demasiados caracteres para ser uma expressao regular, por isso vai dar erro e pedir nova introdução");
    }

}
