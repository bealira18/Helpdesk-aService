package catalogomanagement.domain;

import eapli.base.catalogomanagement.domain.Icone;
import org.junit.Test;

public class IconeTeste {

    @Test(expected = NullPointerException.class)
    public void testeNomeDoIconeNaoPodeSerNull() {
        Icone icone=new Icone(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeNomeDoIconeTemDeAcabarNumaExtensaoConhecida() {
        Icone icone=new Icone("icone");
    }

}
