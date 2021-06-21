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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CumprimentoSLAUI extends AbstractUI {

    private final ListarIncumprimentoSLA listarIncumprimentoSLA=new ListarIncumprimentoSLA();
    private final ListarCatalogosController listarCatalogosController=new ListarCatalogosController();

    @Override
    protected boolean doShow(){

        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dataI = new Date();
        Date dataF = new Date();

        String datai= Console.readLine("\nData incial (dd/MM/yyyy): ");
        String dataf= Console.readLine("\nData incial dd/MM/yyyy: ");

        try {
            dataI=DateFor.parse(datai);
            dataF=DateFor.parse(dataf);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Pedido> pedidos=listarIncumprimentoSLA.pedidosPorData(dataI,dataF);
        Iterable<Catalogo> catalogos=listarCatalogosController.listarCatalogos();


        for(Catalogo c : catalogos){
            System.out.println("Titulo Catalogo: "+c.obterTitulo());
            System.out.println("Niveis de Criticidade: "+c.obterNivelCriticidade());
            Iterable<Servico> servicos=listarIncumprimentoSLA.ServicoPorCatalogo(c.obterId());
            for(Servico s : servicos){
                Iterable<Pedido> pd=listarIncumprimentoSLA.pedidosDeServico(s.obterId(),pedidos);
                for(Pedido p : pd){
                    Iterable<InfoTarefa> it=p.obterListaTarefas();
                    for(InfoTarefa t : it){
                        System.out.println("Tarefa: "+t.obterId());
                        System.out.println("Tempo decorrido: "+t.obterTempoDecorrido());
                        System.out.println("Tempo médio: "+t.obterTarefa().obterTempoMedio()+"\n");
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
