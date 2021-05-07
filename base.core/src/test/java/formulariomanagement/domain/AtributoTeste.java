package formulariomanagement.domain;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.formulariomanagement.domain.Atributo;
import org.junit.Test;

public class AtributoTeste {

    @Test(expected = IllegalArgumentException.class)
    public void nullEmTodosParametros() {
        Atributo instance = new Atributo(null,null,null,null,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullNumParametro() {
        Atributo instance=new Atributo("atributo","etiqueta","descricao",null,"String");
    }


}
