package colaboradormanagement.domain;

import eapli.base.colaboradormanagement.domain.Colaborador;
import org.junit.Test;

import java.util.Date;

public class ColaboradorTeste {

    @Test(expected = IllegalArgumentException.class)
    public void nullEmTodosParametros() {
        Colaborador instance = new Colaborador(0,null,null,null,null,false,null,null,null,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullNumParametro() {
        Colaborador instance=new Colaborador(36,"Bea","Beatriz Lira",new Date(2001/05/18),"Gaia",true,null,"idk","idk",181823L);
    }


}
