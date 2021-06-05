package eapli.base.app.backoffice.console.presentation.catalogo;

import eapli.base.catalogomanagement.application.ListarCatalogosController;
import eapli.base.catalogomanagement.application.PesquisarCatalogoController;
import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class PesquisarCatalogoUI extends AbstractUI {

    private final PesquisarCatalogoController controller=new PesquisarCatalogoController();
    private final ListarCatalogosController controlleraux=new ListarCatalogosController();

    @Override
    protected boolean doShow(){

        try{
            Iterable<Catalogo> catalogos=controlleraux.listarCatalogos();

            for(Catalogo c :catalogos){
                System.out.println(c.obterTitulo()+"\n");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        String titulo= Console.readLine("Titulo pretendido: ");

        while(controller.procurarCatalogoTitulo(titulo)==null)
            titulo= Console.readLine("Titulo pretendido: ");

        try{
            Catalogo catalogo=controller.procurarCatalogoTitulo(titulo);
            System.out.println(catalogo.toString());
        }catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public String headline() {
        return "Procurar Catalogo por titulo";
    }

}
