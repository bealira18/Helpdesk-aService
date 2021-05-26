package eapli.base.formulariomanagement.application;

import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.RespostasFormulario;
import eapli.base.formulariomanagement.repository.RespostasFormularioRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AdicionarRespostasFormularioController {

    private final RespostasFormularioRepository respostasFormularioRepository= PersistenceContext.repositories().respostasFormulario();

    public RespostasFormulario responderFormulario(Atributo atributo,String resposta){

        final RespostasFormulario respostaAtributo=new RespostasFormulario(resposta);

        respostaAtributo.relacionarAtributo(atributo);

        if(validarResposta(respostaAtributo,atributo))
            respostaAtributo.mudarValido(true);
        else
            respostaAtributo.mudarValido(false);

        return respostasFormularioRepository.save(respostaAtributo);

    }

    public boolean validarResposta(RespostasFormulario resposta,Atributo atributo){

        if(resposta.obterResposta().isEmpty())
            return false;

        Pattern p = Pattern.compile(atributo.obterExpressaoRegular().obterExpressaoRegular());

        // Pattern class contains matcher() method
        // to find matching between given number
        // and regular expression
        Matcher m = p.matcher(resposta.obterResposta());

        if(m.matches())
            return true;
        else
            return false;

    }

}
