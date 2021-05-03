package equipamanagement.domain;

import eapli.base.equipamanagement.domain.Designacao;
import org.junit.Test;

public class DesignacaoTeste {

    @Test(expected = IllegalArgumentException.class)
    public void regraDesignacao() {
        Designacao Designacao = new Designacao(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void regraDesignacao2() {
        Designacao Designacao = new Designacao("Eu na verdade nao sei o que escrever, apenas sei que tem de ter mais de 50 caracteres.");
    }

}
