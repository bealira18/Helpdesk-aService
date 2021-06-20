package eapli.base.app.backoffice.console.presentation.pedido;

import eapli.base.catalogomanagement.application.ListarCatalogosController;
import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.nivelcriticidademanagement.application.ListarIncumprimentoSLA;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.Date;
import java.util.List;

public class CumprimentoSLAUI extends AbstractUI {

    private final ListarIncumprimentoSLA listarIncumprimentoSLA=new ListarIncumprimentoSLA();
    private final ListarCatalogosController listarCatalogosController=new ListarCatalogosController();

    @Override
    protected boolean doShow(){

        Date dataI= Console.readDate("\nData incial: ","dd/mm/yyyy");
        Date dataF= Console.readDate("\nData incial: ","dd/mm/yyyy");

        List<Pedido> pedidos=listarIncumprimentoSLA.pedidosPorData(dataI,dataF);
        Iterable<Catalogo> catalogos=listarCatalogosController.listarCatalogos();

        for(Catalogo c : catalogos){
            System.out.println("Titulo Catalogo: "+c.obterTitulo());
            System.out.println("Niveis de Criticidade: "+c.obterNivelCriticidade());

            for(Servico s : listarIncumprimentoSLA.ServicoPorCatalogo(c.obterId())){

                for(Pedido p : listarIncumprimentoSLA.pedidosDeServico(s.obterId(),pedidos)){

                    for(InfoTarefa t : p.obterListaTarefas()){

                        System.out.println("Tempo decorrido"+t.obterTempoDecorrido());
                        System.out.println("Tempo médio"+t.obterTarefa().obterTempoMedio());
                    }
                }
            }
        }

        return true;
    }

    @Override
    public String headline() {
        return "Incumprimento SLA";
    }

}
