package eapli.base.app.backoffice.console.presentation.catalogo;

import eapli.base.catalogomanagement.application.AssociarCriteriosEspecificacaoACatalogoController;
import eapli.base.catalogomanagement.application.ListarCatalogosController;
import eapli.base.catalogomanagement.application.PesquisarCatalogoController;
import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.CriteriosEspecificacao;
import eapli.base.equipamanagement.application.ListarEquipasController;
import eapli.base.equipamanagement.application.PesquisarEquipaController;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class AssociarEquipaACatalogoUI extends AbstractUI {

    private final AssociarCriteriosEspecificacaoACatalogoController controllerassociacao=new AssociarCriteriosEspecificacaoACatalogoController();
    private final ListarCatalogosController controllerlistacat=new ListarCatalogosController();
    private final PesquisarCatalogoController controllerpesqcat=new PesquisarCatalogoController();
    private final ListarEquipasController controllerlistaeq=new ListarEquipasController();
    private final PesquisarEquipaController controllerpesqeq=new PesquisarEquipaController();

    @Override
    protected boolean doShow(){

        //saber a que catalogo pretende adicionar
        //mostrar catalogos e pedir 1

        Iterable<Catalogo> catalogos=controllerlistacat.listarCatalogos();

        for(Catalogo c : catalogos){
            System.out.println(c.obterTitulo()+"\n");
        }

        System.out.println("Titulo do catalogo a que pretende adicionar a equipa:\n");
        String titulo= Console.readLine("Titulo: ");

        while(controllerpesqcat.procurarCatalogoTitulo(titulo)==null)
            titulo= Console.readLine("Titulo pretendido: ");

        Catalogo catalogo=controllerpesqcat.procurarCatalogoTitulo(titulo);

        CriteriosEspecificacao criteriosEspecificacao=catalogo.obterCriteriosEspecificacao();

        //mostrar a que equipas esse catalogo já está atribuido

        System.out.println("Catalogo já tem a(s) equipa(s):\n");
        List<Equipa> equipasCE=criteriosEspecificacao.obterEquipas();

        for(Equipa e : equipasCE){
            System.out.println(e.toString()+"\n");
        }

        //mostrar que equipas ele pode associar ao catalogo (aquelas que ainda nao estao)

        System.out.println("\nPodem ser associadas as seguintes equipas:\n");
        Iterable<Equipa> equipas=controllerlistaeq.listarEquipas();

        boolean temEquipasParaAdicionar=false;

        for(Equipa e : equipas){
            for(Equipa eq : equipasCE){
                if(e.acronimo().compareTo(eq.acronimo())!=0){
                    System.out.println(e.acronimo()+"\n");
                    temEquipasParaAdicionar=true;
                }
            }
        }

        if(temEquipasParaAdicionar==true) {
            //pedir para escolher uma equipa
            String acronimo = Console.readLine("Acronimo: ");

            while (controllerpesqeq.procurarEquipaPorAcronimo(acronimo) == null)
                acronimo = Console.readLine("Acronimo pretendido: ");

            //adicionar equipa aos criterios de especificação

            Equipa equipa = controllerpesqeq.procurarEquipaPorAcronimo(acronimo);

            criteriosEspecificacao.addEquipa(equipa);

            //fazer a associaçao

            try {
                controllerassociacao.associarCriteriosEspecificacaoACatalogo(catalogo, criteriosEspecificacao);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("não tem equipas para adicionar");
        }

        System.out.println("Associado com sucesso!\n");

        return true;
    }

    @Override
    public String headline() {
        return "Associar equipa a catalogo";
    }

}
