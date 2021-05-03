package catalogomanagement.domain;

import eapli.base.catalogomanagement.domain.Catalogo;
import org.junit.Test;

public class CatalogoTeste {

    @Test(expected = IllegalArgumentException.class)
    public void nullEmTodosParametros() {
        Catalogo instance = new Catalogo(null,null,null,0,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullNumParametro() {
        Catalogo instance=new Catalogo("idk","descricaoBreve",null,8,"icone.jpg");
    }

}
