package formulariomanagement.domain;

import eapli.base.formulariomanagement.domain.Formulario;
import org.junit.Test;

public class FormularioTeste {

    @Test(expected = IllegalArgumentException.class)
    public void nullEmTodosParametros() {
        Formulario instance = new Formulario(null);
    }

}
