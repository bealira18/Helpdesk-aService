package equipamanagement.domain;

import eapli.base.equipamanagement.domain.Descricao;
import eapli.base.equipamanagement.domain.Designacao;
import org.junit.Test;

public class DescricaoTeste {

    @Test(expected = IllegalArgumentException.class)
    public void regraDescricao1() {
        Descricao descricao = new Descricao(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void regraDescricao2() {
        Descricao descricao = new Descricao("Eu na verdade nao sei o que escrever, apenas sei que tem de ter mais de 50 caracteres.");
    }

}
