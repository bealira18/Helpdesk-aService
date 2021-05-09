package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.base.colaboradormanagement.application.AdicionarColaboradorController;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.Date;

public class AddColaboradorUI extends AbstractUI {

    private final AdicionarColaboradorController controller=new AdicionarColaboradorController();

    @Override
    protected boolean doShow(){

        final Iterable<Numero> numeros=controller.mostrarNumerosIndisponiveis();

        if(numeros!=null)
            System.out.println("Numeros indisponiveis:\n");

        for(Numero n : numeros){
            System.out.println(n.toString());
        }

        int num=Console.readInteger("Numero pretendido: ");

        while(controller.procurarColaboradorPorNumero(num)!=null)
            num=Console.readInteger("Numero pretendido: ");

        final String nomeCurto=Console.readLine("Nome curto: ");
        final String nomeLongo=Console.readLine("Nome longo: ");
        final Date dataNascimento=Console.readDate("Data de nascimento: ");
        final String localResidencia=Console.readLine("Local residencia: ");
        int humano=Console.readInteger("1- empresa, 0- colaborador: ");

        while(humano!=1 && humano!=0)
            humano=Console.readInteger("1- empresa, 0- colaborador: ");

        boolean serHumano;
        if(humano==1)
            serHumano=false;
        else
            serHumano=true;

        final String email=Console.readLine("Email: ");
        final String perfilColaborador=Console.readLine("Perfil do colaborador: ");
        final String funcao=Console.readLine("Função: ");
        final Long contacto=Console.readLong("Contacto de telemóvel: ");

        try {
            this.controller.adicionarColaborador(num,nomeCurto,nomeLongo,dataNascimento,localResidencia,serHumano,email,perfilColaborador,funcao,contacto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }

    @Override
    public String headline() {
        return "Adicionar Colaborador";
    }

}
