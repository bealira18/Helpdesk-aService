package nivelcriticidademanagement.domain;

import eapli.base.nivelcriticidademanagement.domain.NivelCriticidade;
import org.junit.Test;


public class NivelCriticidadeTeste {

    @Test(expected = IllegalArgumentException.class)
    public void nullEmTodosParametros() {
        NivelCriticidade instance1 = new NivelCriticidade(null,0,0,0,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullNumParametro() {
        NivelCriticidade instance2 = new NivelCriticidade("Qualquer coisa",30,54,5,null);
    }
}
