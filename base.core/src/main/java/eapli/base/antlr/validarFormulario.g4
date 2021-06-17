grammar validarFormulario;

prog: stat+;

stat: expr NEWLINE # printExpr
| condicao NEWLINE # printCondicao
| ID '-' expr NEWLINE # assign
| NEWLINE # blank
;

expr: expr op=('*'|'/') expr # MulDiv
| expr op=('+'|'-') expr # AddSub
| ',' expr # MaisQualquerCoisa
| INT CAMPOS OBRIGATORIO # CampoObrigatorio
| INT CAMPOS VAZIA # CampoNaoPreencher
| INT CAMPOS TAMANHO '-' INT # DefinirTamanho
| QUANTIDADE # Quantidade
| EXPRESSAOR # ExpressaoRegular
| INT CAMPOS EQUALS equival # Equals
| INT # int
| ID # id
| '(' expr ')' # parens
;

equival:
| ID '||' equival
| ID
;

condicao: SE INT CAMPOS '-' ID expr+ # CondicaoValidacao
| SE INT CAMPOS VAZIO expr+ # CondicaoValidacao
| SE INT CAMPOS OBRIGATORIO expr+ # CondicaoValidacao
;

NEWLINE : [\r\n]+ ;
INT : [0-9]+ ;
ID : [a-z]+ ;
MUL : '*' ; // assigns token name to '*' used above in grammar
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
ATR : '=' ;
LPR : '(' ;
RPR : ')' ;
CAMPOS : 'Campo' ;
SE : 'Se' ;
OBRIGATORIO : 'Obrigatorio' ;
VAZIO : 'Vazio' ;
TAMANHO : 'Tamanho' ;
EXPRESSAOR : 'ExpressaoRegular';
QUANTIDADE : 'Quantidade:'INT ;
EQUALS : 'Equivale:' ;
WS : [ \t]+ -> skip;