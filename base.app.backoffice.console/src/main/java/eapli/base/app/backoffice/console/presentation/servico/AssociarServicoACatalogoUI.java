package eapli.base.app.backoffice.console.presentation.servico;

import eapli.base.catalogomanagement.application.AssociarServicoACatalogoController;
import eapli.base.catalogomanagement.application.ListarCatalogosController;
import eapli.base.catalogomanagement.application.PesquisarCatalogoController;
import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.servicomanagement.application.ListarServicosController;
import eapli.base.servicomanagement.application.PesquisarServicoController;
import eapli.base.servicomanagement.domain.Servico;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class AssociarServicoACatalogoUI extends AbstractUI {

    private final AssociarServicoACatalogoController controller=new AssociarServicoACatalogoController();
    private final ListarCatalogosController controllerlistcat=new ListarCatalogosController();
    private final PesquisarCatalogoController controllerpesqcat=new PesquisarCatalogoController();
    private final ListarServicosController controllerlistserv=new ListarServicosController();
    private final PesquisarServicoController controllerpesqserv=new PesquisarServicoController();

    @Override
    protected boolean doShow(){

        //mostrar catalogos
        Iterable<Catalogo> catalogos=controllerlistcat.listarCatalogos();

        if(catalogos!=null)
            System.out.println("Catalogos possiveis:\n");
        else
            System.out.println("Ainda não existem catalogos");

        for(Catalogo c : catalogos){
            System.out.println(c.obterTitulo());
            System.out.println();
        }

        //escolher catalogo onde se quer adicionar

        String tituloCatalogo= Console.readLine("\nTitulo catalogo pretendido: ");

        while(controllerpesqcat.procurarCatalogoTitulo(tituloCatalogo)==null)
            tituloCatalogo=Console.readLine("Titulo catalogo pretendido: ");

        //mostrar que serviços se pode adicionar

        Catalogo catalogo=controllerpesqcat.procurarCatalogoTitulo(tituloCatalogo);

        List<Servico> servicosEmCatalogo=catalogo.servicos();

        Iterable<Servico> todosServicos=controllerlistserv.listarServicos();

        for(Servico s : todosServicos){
            if(s.estaCompleto() && s.estaAtivo() && !servicosEmCatalogo.contains(s)){
                System.out.println(s.obterCod()+"\n");
            }
        }

        //escolher serviço

        String codServico= Console.readLine("\nCodigo serviço pretendido: ");

        while(controllerpesqserv.procurarPorCod(codServico)==null)
            codServico=Console.readLine("Codigo serviço pretendido: ");

        //associar


        try{
            controller.associarServicoACatalogo(tituloCatalogo,codServico);
            System.out.println("Associado com sucesso");
        }catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public String headline() {
        return "Associar serviço a catalogo";
    }

}
