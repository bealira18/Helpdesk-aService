grammar validarFormulario;

prog: stat+;

stat: expr NEWLINE # printExpr
| exprCampo NEWLINE # printCampo
| condicao NEWLINE # printCondicao
| ID '=' expr NEWLINE # assign
| NEWLINE # blank
;

expr: expr op=('*'|'/') expr # MulDiv
| expr op=('+'|'-') expr # AddSub
| ',' expr # MaisQualquerCoisa
| INT # int
| ID # id
| '(' expr ')' # parens
;

exprCampo: INT CAMPOS OBRIGATORIO # CampoObrigatorio
| INT CAMPOS VAZIO # CampoNaoPreencher
| INT CAMPOS TAMANHO '=' INT # DefinirTamanho
| INT CAMPOS EXPRESSAOR # ExpressaoRegular
| INT CAMPOS EQUALS equival # Equals
;

equival: ID '||' ID '||' ID # nada
| ID '||' ID # nada
| ID # nada
;

condicao: SE INT CAMPOS '=' ID exprCampo # CondicaoValidacao
| SE INT CAMPOS VAZIO exprCampo # CondicaoValidacao1
| SE INT CAMPOS OBRIGATORIO exprCampo # CondicaoValidacao2
| QUANTIDADE '=' INT # Quantidade
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
QUANTIDADE : 'Quantidade:'INT ;
EQUALS : 'Equivale:' ;
WS : [ \t]+ -> skip;