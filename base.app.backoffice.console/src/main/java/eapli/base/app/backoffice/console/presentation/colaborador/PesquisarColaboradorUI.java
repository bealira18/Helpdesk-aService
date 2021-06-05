package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.base.colaboradormanagement.application.AdicionarColaboradorController;
import eapli.base.colaboradormanagement.application.PesquisarColaboradorController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class PesquisarColaboradorUI extends AbstractUI {

    private final PesquisarColaboradorController controller=new PesquisarColaboradorController();
    private final AdicionarColaboradorController controlleraux=new AdicionarColaboradorController();

    @Override
    protected boolean doShow(){

        final Iterable<Numero> numeros=controlleraux.mostrarNumerosIndisponiveis();

        if(numeros!=null)
            System.out.println("Numeros possiveis:\n");

        for(Numero n : numeros){
            System.out.println(n.toString());
        }

        int num= Console.readInteger("Numero pretendido: ");

        while(controller.procurarColaboradorNumero(num)==null)
            num= Console.readInteger("Numero pretendido: ");

        try{
            Colaborador colaborador=controller.procurarColaboradorNumero(num);

            System.out.println(colaborador.toString());

        }catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }

    @Override
    public String headline() {
        return "Procurar Colaborador";
    }

}
