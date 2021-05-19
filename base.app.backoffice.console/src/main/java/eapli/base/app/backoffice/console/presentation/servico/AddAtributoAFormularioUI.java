package eapli.base.app.backoffice.console.presentation.servico;

import eapli.base.formulariomanagement.application.AdicionarAtributoController;
import eapli.base.formulariomanagement.application.AssociarAtributoAFormularioController;
import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.servicomanagement.application.ListarServicosController;
import eapli.base.servicomanagement.application.PesquisarServicoController;
import eapli.base.servicomanagement.domain.Servico;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class AddAtributoAFormularioUI extends AbstractUI {

    private final AdicionarAtributoController controllerAdd=new AdicionarAtributoController();
    private final AssociarAtributoAFormularioController controllerAss=new AssociarAtributoAFormularioController();
    private final PesquisarServicoController controllerPesq=new PesquisarServicoController();
    private final ListarServicosController controllerList=new ListarServicosController();

    @Override
    protected boolean doShow(){

        try {
            Iterable<Servico> servicos = controllerList.listarServicos();

            for (Servico s : servicos) {
                System.out.println(s.obterTitulo());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        String titulo= Console.readLine("Titulo pretendido: ");

        while(controllerPesq.procurarServicoPorTitulo(titulo)==null)
            titulo= Console.readLine("Acronimo pretendido: ");

        Servico servico=controllerPesq.procurarServicoPorTitulo(titulo);

        int aux=1;

        while(aux==1){
            //tornar nome obrigatorio
            final String nomeAtributo= Console.readLine("Nome Atributo: ");
            final String etiqueta= Console.readLine("Etiqueta: ");
            final String descricao= Console.readLine("Descricao: ");
            final String expressao= Console.readLine("Expressao Regular: ");
            final String tipoDadosBase= Console.readLine("Tipo Dados Base: ");

            Atributo a=new Atributo();

            try{
                a=controllerAdd.adicionarAtributo(nomeAtributo,etiqueta,descricao,expressao,tipoDadosBase);
            }catch (Exception e) {
                e.printStackTrace();
            }

            controllerAss.associarAtributoAFormularioIds(servico.obterFormulario().obterId(),a.obterId());

            System.out.println("\nAtributo adicionado!");

            aux=Console.readInteger("\nAdicionar mais atributos ao formulario?\n0-não\n1-sim");
        }

        return true;
    }

    @Override
    public String headline() {
        return "Adicionar Atributo a um Formulario";
    }

}
