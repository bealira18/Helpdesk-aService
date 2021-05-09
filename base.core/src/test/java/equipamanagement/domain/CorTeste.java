package equipamanagement.domain;

import eapli.base.equipamanagement.domain.Cor;
import org.junit.Test;

public class CorTeste {
    
       @Test(expected = IllegalArgumentException.class)
    public void regraCor() {
        Cor cor=new Cor(null);
    }
    
}
