package servicomanagement.domain;

import eapli.base.servicomanagement.domain.Servico;
import org.junit.Assert;
import org.junit.Test;

public class ServicoTeste {
    @Test(expected = IllegalArgumentException.class)
    public void nullEmTodosParametros() {
        Servico instance = new Servico(null,null,null,null,null,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullNumParametro() {
        Servico instance=new Servico("cod",null, "Tít", "TítuloExemplo", "exemplo, titulo", "tituloExemplo.jpg");
        Servico instance2=new Servico("cod","Título", null, "TítuloExemplo", "exemplo, titulo", "tituloExemplo.jpg");
        Servico instance3=new Servico("cod","Título", "Tít", null, "exemplo, titulo", "tituloExemplo.jpg");
        Servico instance4=new Servico("cod","Título", "Tít", "TítuloExemplo", null, "tituloExemplo.jpg");
        Servico instance5=new Servico("cod","Título", "Tít", "TítuloExemplo", "exemplo, titulo", null);
    }

    @Test
    public void servicoInacabado(){

        Servico instance=new Servico("cod","titulo", "", "", "exemplo", "tituloExemplo.jpg");

        Assert.assertFalse(instance.estaAtivo());

    }

}
