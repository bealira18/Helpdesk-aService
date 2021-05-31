package eapli.base.app.backoffice.console.presentation.catalogo;

import eapli.base.catalogomanagement.application.AdicionarCatalogoController;
import eapli.base.catalogomanagement.application.AdicionarCriteriosEspecificacaoController;
import eapli.base.catalogomanagement.application.AssociarCriteriosEspecificacaoACatalogoController;
import eapli.base.catalogomanagement.application.AssociarNivelCriticidadeACatalogoController;
import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.CriteriosEspecificacao;
import eapli.base.colaboradormanagement.application.ListarColaboradoresController;
import eapli.base.colaboradormanagement.application.PesquisarColaboradorController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.application.ListarEquipasController;
import eapli.base.equipamanagement.application.PesquisarEquipaController;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.nivelcriticidademanagement.application.DefinirNivelCriticidadeController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class AddCatalogoUI extends AbstractUI {

    private final AdicionarCatalogoController controller=new AdicionarCatalogoController();
    private final ListarColaboradoresController controlleraux=new ListarColaboradoresController();
    private final PesquisarColaboradorController controllerauxpesq=new PesquisarColaboradorController();
    private final AdicionarCriteriosEspecificacaoController controllerCE=new AdicionarCriteriosEspecificacaoController();
    private final ListarEquipasController controlerEquipas=new ListarEquipasController();
    private final PesquisarEquipaController controllerPesqEq=new PesquisarEquipaController();
    private final AssociarCriteriosEspecificacaoACatalogoController controllerassociar=new AssociarCriteriosEspecificacaoACatalogoController();
    private final DefinirNivelCriticidadeController definirNivelCriticidadeController=new DefinirNivelCriticidadeController();
    private final AssociarNivelCriticidadeACatalogoController associarNivelCriticidadeACatalogoController=new AssociarNivelCriticidadeACatalogoController();

    @Override
    protected boolean doShow(){

        final String titulo= Console.readLine("Titulo: ");
        final String descricaoBreve= Console.readLine("Descricao breve: ");
        final String descricaoCompleta= Console.readLine("Descrição completa: ");

        //listar colaboradores
        Iterable<Colaborador> colaboradores=controlleraux.listarColaboradores();

        System.out.println("Colaboradores disponiveis:\n");
        for(Colaborador c : colaboradores){
            System.out.println(c.toString() + "\n");
        }

        int numeroColaborador=Console.readInteger("Numero de colaborador responsável: ");

        while(controllerauxpesq.procurarColaboradorPorNumero(numeroColaborador)==null)
            numeroColaborador= Console.readInteger("Numero pretendido: ");

        final String icone=Console.readLine("Nome do icone em jpg ou png: ");

        Catalogo c=new Catalogo();
        try{
            c=this.controller.adicionarCatalogo(titulo,descricaoBreve,descricaoCompleta,numeroColaborador,icone);
            //System.out.println("Adicionado com sucesso!\n");
        }catch (Exception e) {
            e.printStackTrace();
        }

        //catalogo adicionado
        //necessario adicionar criterios de especificação

        System.out.println("Adicionar criterios de especificação para o catalogo adicionado\n");

        CriteriosEspecificacao ce=new CriteriosEspecificacao();
        try{
            ce=adicionarCriteriosEspecificacao();
        }catch (Exception e) {
            e.printStackTrace();
        }

        try{
            controllerassociar.associarCriteriosEspecificacaoACatalogo(c,ce);
        }catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("\nDefinir nivel de criticidade\n");

        final String objetivo=Console.readLine("Objetivo do Nivel de Criticidade: ");
        final int tempoMaximoA=Console.readInteger("Tempo Maximo das Tarefas de Aprovação (minutos): ");
        final int tempoMaximoR=Console.readInteger("Tempo Maximo das Tarefas de Resolução (minutos): ");
        int valor=Console.readInteger("Valor de 1 a 5, para caraterizar: ");

        while(valor<1 || valor>5)
            valor=Console.readInteger("Valor de 1 a 5, para caraterizar: ");

        String etiqueta=Console.readLine("Etiqueta: ");

        definirNivelCriticidadeController.definirNivelCriticidade(objetivo,tempoMaximoA,tempoMaximoR,valor,etiqueta);

        try {
            associarNivelCriticidadeACatalogoController.associarNivelCriticidadeACatalogo(titulo, objetivo);
            System.out.println("Adicionado com sucesso!\n");
        }catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    public CriteriosEspecificacao adicionarCriteriosEspecificacao(){

        //listar equipas para ver quais adicionar

        Iterable<Equipa> equipas=controlerEquipas.listarEquipas();

        for(Equipa e : equipas){
            System.out.println(e.toString()+"\n");
        }

        String acronimo=Console.readLine("Acronimo da equipa a adicionar: ");

        while(controllerPesqEq.procurarEquipaPorAcronimo(acronimo)==null)
            acronimo= Console.readLine("Equipa pretendida: ");

        CriteriosEspecificacao ce=controllerCE.adicionarCriteriosEspecificacao(acronimo);

        return ce;
    }

    @Override
    public String headline() {
        return "Adicionar Catalogo";
    }

}
