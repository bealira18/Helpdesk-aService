package equipamanagement.domain;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.equipamanagement.application.AssociarColaboradorAEquipaController;
import eapli.base.equipamanagement.domain.Equipa;
import org.junit.Test;

import java.util.Date;
import java.util.WeakHashMap;

import static org.junit.Assert.assertEquals;

public class EquipaTeste {

    @Test(expected = IllegalArgumentException.class)
    public void nullEmTodosParametros() {
        Equipa instance = new Equipa(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullNumParametro() {
        Equipa instance = new Equipa("nao null", null);
        Equipa instance2 = new Equipa(null, "nao null");
    }

    //aqui preciso de tirar as duvidas com o stor para ver como vou buscar o id da Equipa a base de dados
    //@Test
    //public void associarColaboradorAEquipa(){
    //    Equipa equipa1 = new Equipa("AZE", "s");
    //    Colaborador colab1 = new Colaborador(122, "as", "kmkm", new Date(2001/05/18), "wedd", true,"sriuf8F55", "dkdsdf@gmail.com", "oi", "ok", "ok", 91812 );
    //    AssociarColaboradorAEquipaController acec = new AssociarColaboradorAEquipaController();
    //    acec.associarColaboradorAEquipa(equipa1, colab1);
    //    boolean expected = true;
    //    boolean result = false;
    //    for (Colaborador colab : equipa1.colaboradores()){
    //        if (colab.equals(colab1)){
    //            result = true;
    //            break;
    //        }
    //    }
    //    assertEquals(expected, result);
    //}
}
