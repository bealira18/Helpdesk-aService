package equipamanagement.domain;

import eapli.base.equipamanagement.domain.TipoEquipa;
import org.junit.Test;

public class TipoEquipaTeste {

    @Test(expected = IllegalArgumentException.class)
    public void nullEmTodosParametros() {
        TipoEquipa instance = new TipoEquipa(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullNumParametro() {
        TipoEquipa instance1 = new TipoEquipa("Equipa", null);
        TipoEquipa instance2 = new TipoEquipa(null, "#000000");
    }
}
