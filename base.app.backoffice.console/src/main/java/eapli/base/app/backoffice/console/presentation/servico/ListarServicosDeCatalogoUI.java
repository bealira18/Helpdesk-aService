package eapli.base.app.backoffice.console.presentation.servico;

import eapli.base.catalogomanagement.application.ListarCatalogosController;
import eapli.base.catalogomanagement.application.PesquisarCatalogoController;
import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.servicomanagement.application.ListarServicosDeCatalogoController;
import eapli.base.servicomanagement.domain.Servico;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class ListarServicosDeCatalogoUI extends AbstractUI {

    private final ListarServicosDeCatalogoController controller=new ListarServicosDeCatalogoController();
    private final ListarCatalogosController controllerlistcat=new ListarCatalogosController();
    private final PesquisarCatalogoController controllerpesqcat=new PesquisarCatalogoController();

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

        //escolher catalogo

        String tituloCatalogo= Console.readLine("\nTitulo catalogo pretendido: ");

        while(controllerpesqcat.procurarCatalogoTitulo(tituloCatalogo)==null)
            tituloCatalogo=Console.readLine("Titulo catalogo pretendido: ");

        //listar serviços

        List<Servico> servicos=controller.listarServicosCatalogo(tituloCatalogo);

        for(Servico s : servicos)
            System.out.println(s.toString()+"\n");

        return true;
    }

    @Override
    public String headline() {
        return "Listar serviços de um catalogo";
    }

}
