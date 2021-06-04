grammar lapr4;

@parser::members {

    public boolean compararExprComAtributo(String expressao,String resposta,int opcional){

        if(!resposta.isEmpty()){
            Pattern p = Pattern.compile(expressao);

            // Pattern class contains matcher() method
            // to find matching between given number
            // and regular expression
            Matcher m = p.matcher(resposta);

            if(m.matches())
                return true;
            else
                return false;
        }

        if(resposta.isEmpty() && opcional==0)
            return false;
        else
            return true;
    }
}

expressao: 'if' comparador;

comparador: EXPRESSAO RESPOSTA OPCIONAL {System.out.printl("qualquer coisa"); compararExprComAtributo($EXPRESSAO,$RESPOSTA,$OPCIONAL)}
            ;

EXPRESSAO: ;

RESPOSTA: ;

OPCIONAL: ;

WS: [ ] -> skip;