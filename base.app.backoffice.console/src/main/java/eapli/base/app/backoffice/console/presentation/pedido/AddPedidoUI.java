package eapli.base.app.backoffice.console.presentation.pedido;

import eapli.base.catalogomanagement.application.ListarCatálogosEServicosController;
import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.colaboradormanagement.application.ColaboradorComUserController;
import eapli.base.colaboradormanagement.application.ListarColaboradoresController;
import eapli.base.colaboradormanagement.application.PesquisarColaboradorController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.formulariomanagement.application.AdicionarRespostasFormularioController;
import eapli.base.formulariomanagement.application.ListarAtributosDeFormularioController;
import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.pedidomanagement.application.AdicionarPedidoController;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.servicomanagement.application.PesquisarServicoController;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.tarefamanagement.application.CriarTarefaController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.Date;
import java.util.List;

public class AddPedidoUI extends AbstractUI {

    private final AdicionarPedidoController adicionarPedidoController=new AdicionarPedidoController();
    private final ListarCatálogosEServicosController listarCatálogosEServicosController=new ListarCatálogosEServicosController();
    private final ColaboradorComUserController colaboradorComUserController=new ColaboradorComUserController();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ListarColaboradoresController controllercol=new ListarColaboradoresController();
    private final PesquisarColaboradorController controllerpesqcol=new PesquisarColaboradorController();
    private final ListarCatálogosEServicosController controller=new ListarCatálogosEServicosController();
    private final PesquisarServicoController pesquisarServicoController=new PesquisarServicoController();
    private final ListarAtributosDeFormularioController listarAtributosDeFormularioController=new ListarAtributosDeFormularioController();
    private final AdicionarRespostasFormularioController adicionarRespostasFormularioController=new AdicionarRespostasFormularioController();
    private final CriarTarefaController criarTarefaController=new CriarTarefaController();

    @Override
    protected boolean doShow(){

        int numero=0;

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.COLABORADOR)) {
            numero=colaboradorComUserController.resultColaborador().obterNumero().obterNumero();
        }else{
            //mostrar colaboradores
            Iterable<Colaborador> colaboradores=controllercol.listarColaboradores();

            for(Colaborador c : colaboradores){
                System.out.println(c.obterNumero()+"\n");
            }

            //escolher colaborador

            numero= Console.readInteger("\nNumero pretendido: ");

            while(controllerpesqcol.procurarColaboradorNumero(numero)==null)
                numero=Console.readInteger("Titulo colaborador pretendido: ");
        }

        Iterable<Catalogo> catalogos=controller.listarCatálogos(numero);

        System.out.println("Catalogos:\n");

        for(Catalogo c : catalogos)
            System.out.println(c.toString()+"\n");

        Iterable<Servico> servicos=controller.listarServicosDeCatalogo(numero);

        for(Servico s : servicos)
            System.out.println(s.toString()+"\n");

        //escolher serviço

        String cod= Console.readLine("\nEscolha um serviços dos apresentados: ");

        while(pesquisarServicoController.procurarServicoEspecifico(cod,numero)==null)
            cod= Console.readLine("\nEscolha um serviços dos apresentados: ");

        Servico s=pesquisarServicoController.procurarServicoEspecifico(cod,numero);

        System.out.println("Pedido iniciado:\n");

        Date dataLimite= Console.readDate("\nData Limite (yyyy/mm/dd): ");
        String urgencia=Console.readLine("Urgencia (reduzida,moderada,urgente)\nSelecione (r/m/u)");
        //int numeroDestinatario=Console.readInteger("Numero do destinatario do pedido");

        Pedido pedido=new Pedido();

        try{
            pedido=adicionarPedidoController.addPedido(dataLimite,urgencia,numero,cod);
        }catch (Exception e) {
            e.printStackTrace();
        }

        //responder ao formulario de solicitação de serviço

        System.out.println("\nResponder ao formulario de solicitação de pedido");

        List<Atributo> atributos=listarAtributosDeFormularioController.listarAtributosCompletosFormulario(pedido.obterServico().obterFormulario().obterId());

        for(Atributo a : atributos){
            System.out.println(a.obterNome());
            System.out.println(a.obterDescricao());
            String resposta= Console.readLine("\nResposta: ");
            adicionarRespostasFormularioController.responderFormulario(a,resposta);
        }

        System.out.println("Pedido feito com sucesso!");

        criarTarefaController.novaTarefa(s.obterCod(), pedido.obterId());

        return true;
    }

    @Override
    public String headline() {
        return "Adicionar Pedido";
    }

}
