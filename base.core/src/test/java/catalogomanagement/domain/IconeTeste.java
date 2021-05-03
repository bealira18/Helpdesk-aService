package catalogomanagement.domain;

import eapli.base.catalogomanagement.domain.Icone;
import org.junit.Test;

public class IconeTeste {

    @Test(expected = IllegalArgumentException.class)
    public void regraIcone1() {
        Icone icone=new Icone(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void regraIcone2() {
        Icone icone=new Icone("icone");
    }

}
