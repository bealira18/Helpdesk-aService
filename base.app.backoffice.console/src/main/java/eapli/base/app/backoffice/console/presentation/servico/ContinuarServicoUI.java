package eapli.base.app.backoffice.console.presentation.servico;

import eapli.base.servicomanagement.application.EditarServicoController;
import eapli.base.servicomanagement.application.ListarServicosController;
import eapli.base.servicomanagement.application.PesquisarServicoController;
import eapli.base.servicomanagement.domain.Servico;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class ContinuarServicoUI extends AbstractUI {

    private final ListarServicosController controller=new ListarServicosController();
    private final PesquisarServicoController controllerpesq=new PesquisarServicoController();
    private final EditarServicoController controllereditar=new EditarServicoController();

    @Override
    protected boolean doShow(){

        Iterable<Servico> servicosInacabados=controller.listarServicosIncompletos();

        for(Servico s : servicosInacabados){
            System.out.println(s.obterTitulo()+"\n");
        }

        String titulo= Console.readLine("\nTitulo serviço pretendido: ");

        while(controllerpesq.procurarServicoPorTitulo(titulo)==null)
            titulo=Console.readLine("Titulo serviço pretendido: ");

        Servico servico=controllerpesq.procurarServicoPorTitulo(titulo);

        String descricaobreve;
        String descricaocompleta;
        String palavraschave;
        String icone;

        if(servico.obterDescricaoBreve().isEmpty()) {
            descricaobreve = Console.readLine("\nDescricao Breve: ");
            controllereditar.mudarDescricaoBreve(titulo,descricaobreve);
        }

        if(servico.obterDescricaoCompleta().isEmpty()) {
            descricaocompleta = Console.readLine("\nDescricao Completa: ");
            controllereditar.mudarDescricaoCompleta(titulo,descricaocompleta);
        }

        if(servico.obterPalavrasChave().isEmpty()) {
            palavraschave = Console.readLine("\nPalavras chave: ");
            controllereditar.mudarPalavrasChave(titulo,palavraschave);
        }

        if(servico.obterIcone().obterIcone().isEmpty()) {
            icone = Console.readLine("\nIcone em jpg ou png: ");
            controllereditar.mudarIcone(titulo,icone);
        }

        return true;
    }

    @Override
    public String headline() {
        return "Acabar serviço incompleto";
    }

}
