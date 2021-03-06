package tarefamanagement.domain;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.tarefamanagement.application.ReivindicarTarefaController;
import eapli.base.tarefamanagement.domain.EstadoTarefa;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.domain.TarefaManual;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TarefaTeste {

    @Test(expected = IllegalArgumentException.class)
    public void nullEmTodosParametros() {

        //Tarefa instance = new Tarefa("descricao",false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullNumParametro() {

        EstadoTarefa estado = null;
        //Tarefa instance = new Tarefa("descricao",false);
        //Tarefa instance2 = new Tarefa("descricao",false);
    }

//    @Test
//    public void reivindicarTarefa() {
//
//        SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
//        Date d1 = new Date();
//        Date d2 = new Date();
//        try {
//            d1 = forma.parse("24/02/2022");
//            d2 = forma.parse("17/12/2003");
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        EstadoTarefa estado = null;
//        TarefaManual tarefa = new TarefaManual(d1, 5, 3);
//        Colaborador colaborador = new Colaborador(123, "Pedro", "Pedro Lapa", d2, "Paredes", true,
//                "pedrolapa@gmail.com", "perfil", "funçao", "912345678");
//        ReivindicarTarefaController reivTar = new ReivindicarTarefaController();
//        Colaborador expected = reivTar.reivindicarTarefa(tarefa, colaborador);
//        TarefaManual result = null;
//        for (TarefaManual colab : colaborador.tarefas()) {
//            if (colab.equals(tarefa)) {
//                result = colab;
//                break;
//            }
//        }
//        assertEquals(tarefa, result);
//    }
}
