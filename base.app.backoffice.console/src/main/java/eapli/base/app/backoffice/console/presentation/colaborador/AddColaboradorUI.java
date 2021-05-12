package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.base.colaboradormanagement.application.AdicionarColaboradorController;
import eapli.base.colaboradormanagement.domain.Contacto;
import eapli.base.colaboradormanagement.domain.Email;
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
        final Date dataNascimento=Console.readDate("Data de nascimento (yyyy/mm/dd): ");
        final String localResidencia=Console.readLine("Local residencia: ");
        int humano=Console.readInteger("1- empresa, 0- colaborador: ");

        while(humano!=1 && humano!=0)
            humano=Console.readInteger("1- empresa, 0- colaborador: ");

        boolean serHumano;
        if(humano==1)
            serHumano=false;
        else
            serHumano=true;

        String email=Console.readLine("Email: ");

        Email em=new Email(email);
        while(!em.verificaEmail(em.obterEmail())){
            email=Console.readLine("Email: ");
            em.mudarEmail(email);
        }

        final String perfilColaborador=Console.readLine("Perfil do colaborador: ");
        final String funcao=Console.readLine("Função: ");

        String contacto=Console.readLine("Contacto de telemóvel: ");

        Contacto c=new Contacto(contacto);
        while(!c.verificaContacto(c.obterContacto())){
            contacto=Console.readLine("Contacto de telemóvel: ");
            c.mudarContacto(contacto);
        }

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
