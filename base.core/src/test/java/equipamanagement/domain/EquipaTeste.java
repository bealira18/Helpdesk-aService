package equipamanagement.domain;

import eapli.base.equipamanagement.domain.Equipa;
import org.junit.Test;

public class EquipaTeste {

    @Test(expected = IllegalArgumentException.class)
    public void nullEmTodosParametros() {
        Equipa instance = new Equipa(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullNumParametro() {
        Equipa instance = new Equipa("nao null", null);
        Equipa instance2 = new Equipa(null, "nao null");
    }
}
