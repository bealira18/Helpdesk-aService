package catalogomanagement.domain;

import eapli.base.catalogomanagement.domain.DescricaoBreve;
import eapli.base.colaboradormanagement.domain.Email;
import org.junit.Test;

public class DescricaoBreveTeste {

    @Test(expected = IllegalArgumentException.class)
    public void testeAssegurarQueADescricaoBreveNaoPodeSerNula() {
        DescricaoBreve instanceDescricaoBreve = new DescricaoBreve(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeAssgurarQueADescricaoBreveNaoUltrapassaOLimiteDeCaracteres() {
        DescricaoBreve instanceDescricaoBreve = new DescricaoBreve("isto e uma descricao muito grande para ser considerada descricao breve");
    }

}
