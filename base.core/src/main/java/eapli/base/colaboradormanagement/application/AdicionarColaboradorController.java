package eapli.base.colaboradormanagement.application;

import api.SendEmail;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.colaboradormanagement.domain.Passe;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class AdicionarColaboradorController {

    private final ColaboradorRepository colaboradorRepository= PersistenceContext.repositories().colaborador();

    public Colaborador adicionarColaborador(int numero, String nomeCurto, String nomeCompleto, Date dataNascimento, String localResidencia, boolean serHumano,
                                            String email, String perfilColaborador, String funcao, String contacto){

        final Colaborador novoColaborador=new Colaborador(numero,nomeCurto,nomeCompleto,dataNascimento,localResidencia,serHumano,email,perfilColaborador,funcao,contacto);

        novoColaborador.mudarPasse(new Passe(gerarPasse()));
        String subject = "Registo no sistema";
        String body = String.format("Você registou-se com sucesso no nosso sistema e a sua password é %s", novoColaborador.obterPasse().obterPasse());
        SendEmail.sendEmail(novoColaborador.obterEmail().obterEmail(), subject, body);

        return colaboradorRepository.save(novoColaborador);

    }

    public Colaborador procurarColaboradorPorNumero(int numero) {

        Iterable<Colaborador> colaboradores = colaboradorRepository.findAll();

        Colaborador colaborador = null;

        for (Colaborador c : colaboradores) {
            if (c.obterNumero().obterNumero() == numero) {
                colaborador = c;
            }
        }
        return colaborador;
    }

    public List<Numero> mostrarNumerosIndisponiveis(){

        Iterable<Colaborador> colaboradores = colaboradorRepository.findAll();

        List<Numero> numeros=new ArrayList<Numero>();

        for(Colaborador c : colaboradores){
            numeros.add(c.obterNumero());
        }

        return numeros;
    }

    public static String gerarPasse() {
        boolean lowerLetter = false;
        boolean upperLetter = false;
        boolean number = false;
        int passLength = 0;
        int tipo = 0;
        StringBuffer sb = new StringBuffer();
        gerarCaracteres(sb, 6, lowerLetter, upperLetter, number, tipo);
        passLength = 6;
        if (lowerLetter == false){
            tipo = 1;
            gerarCaracteres(sb, 1, lowerLetter, upperLetter, number, tipo);
            passLength++;
        }
        if(upperLetter == false){
            tipo = 2;
            gerarCaracteres(sb, 1, lowerLetter, upperLetter, number, tipo);
            passLength++;
        }
        if(number == false){
            tipo = 3;
            gerarCaracteres(sb, 1, lowerLetter, upperLetter, number, tipo);
            passLength++;
        }
        if(passLength < 8){
            tipo = 0;
            gerarCaracteres(sb, 8 - passLength, lowerLetter, upperLetter, number, tipo);
        }

        return sb.toString();
    }

    public static void gerarCaracteres(StringBuffer sb, int length, boolean lowerLetter, boolean upperLetter, boolean number, int tipo){
        Random r = new Random();
        char[] lowerLetters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
                'h','i', 'j', 'k','l', 'm', 'n','o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x','w',
                'y', 'z'};
        char[] upperLetters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I','J', 'K','L',
                'M', 'N','O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] numbers = {'1','2', '3', '4', '5', '6', '7', '8', '9' , '0'};
        for (int i = 0; i < length; i++) {
            if(tipo == 0){
                tipo = r.nextInt(3) + 1;
            }
            if (tipo == 1){
                sb.append(lowerLetters[r.nextInt(lowerLetters.length)]);
                if(lowerLetter==false){
                    lowerLetter = true;
                }
            }
            if (tipo == 2){
                sb.append(upperLetters[r.nextInt(upperLetters.length)]);
                if(upperLetter==false){
                    upperLetter = true;
                }
            }
            if (tipo == 3){
                sb.append(numbers[r.nextInt(numbers.length)]);
                if(number==false){
                    number = true;
                }
            }
            tipo = 0;
        }
    }

}
