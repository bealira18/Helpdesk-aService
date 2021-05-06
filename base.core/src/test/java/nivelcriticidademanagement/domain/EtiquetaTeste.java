package nivelcriticidademanagement.domain;

import eapli.base.nivelcriticidademanagement.domain.Etiqueta;
import org.junit.Test;

public class EtiquetaTeste {

    @Test(expected = IllegalArgumentException.class)
    public void regraEtiqueta1() {
        Etiqueta e=new Etiqueta(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void regraEtiqueta2() {
        Etiqueta e2 = new Etiqueta("Ola esta tudobem cifnvksmfoasdfin");
    }
}
