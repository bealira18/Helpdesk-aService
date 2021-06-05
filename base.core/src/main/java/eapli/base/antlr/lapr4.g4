grammar lapr4;

@parser::members {

    public boolean compararExprComAtributo(String expressao,String resposta,int opcional){

    }
}

comparador: EXPRESSAO RESPOSTA OPCIONAL TIPODADOS{compararExprComAtributo($EXPRESSAO,$RESPOSTA,$OPCIONAL)}
            ;

EXPRESSAO: ;

RESPOSTA: ;

OPCIONAL: ;

TIPODADOS: ;

WS: [ ] -> skip;