package eapli.base.app.backoffice.console.presentation.catalogo;

import eapli.base.catalogomanagement.application.ListarCatalogosController;
import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.framework.presentation.console.AbstractUI;

public class ListarCatalogoUI extends AbstractUI {

    private final ListarCatalogosController controller=new ListarCatalogosController();

    @Override
    protected boolean doShow(){
        try{
            Iterable<Catalogo> catalogos=controller.listarCatalogos();

            for(Catalogo c : catalogos){
                System.out.println(c.toString()+"\n");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public String headline() {
        return "Listar Catalogos";
    }

}
