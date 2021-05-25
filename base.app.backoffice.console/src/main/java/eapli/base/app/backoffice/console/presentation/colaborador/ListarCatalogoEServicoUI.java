package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.base.catalogomanagement.application.ListarCatálogosEServicosController;
import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.colaboradormanagement.application.ColaboradorComUserController;
import eapli.base.colaboradormanagement.application.ListarColaboradoresController;
import eapli.base.colaboradormanagement.application.PesquisarColaboradorController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.servicomanagement.domain.Servico;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class ListarCatalogoEServicoUI extends AbstractUI {

    private final ListarCatálogosEServicosController controller=new ListarCatálogosEServicosController();
    private final ListarColaboradoresController controllercol=new ListarColaboradoresController();
    private final PesquisarColaboradorController controllerpesqcol=new PesquisarColaboradorController();
    private final ColaboradorComUserController colaboradorComUserController=new ColaboradorComUserController();

    @Override
    protected boolean doShow(){

        //mostrar colaboradores
        Iterable<Colaborador> colaboradores=controllercol.listarColaboradores();

        for(Colaborador c : colaboradores){
            System.out.println(c.obterNumero()+"\n");
        }

        //escolher colaborador

        //int numero=colaboradorComUserController.resultColaborador().obterNumero().obterNumero();

        int numero= Console.readInteger("\nNumero pretendido: ");

        while(controllerpesqcol.procurarColaboradorPorNumero(numero)==null)
            numero=Console.readInteger("Titulo colaborador pretendido: ");

        Iterable<Catalogo> catalogos=controller.listarCatálogos(numero);

        System.out.println("Catalogos:\n");

        for(Catalogo c : catalogos)
            System.out.println(c.toString()+"\n");

        Iterable<Servico> servicos=controller.listarServicosDeCatalogo(numero);

        for(Servico s : servicos)
            System.out.println(s.toString()+"\n");

        return true;
    }

    @Override
    public String headline() {
        return "Catalogos que um colaborador tem acesso";
    }

}
