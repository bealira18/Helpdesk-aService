grammar validarTarefaAutomatica;

start: instrucao+;

instrucao: CONSULTA consulta NEWLINE # consultarDados
| CALCULOS consulta ', ' calculos NEWLINE # calcularDados
| EMAIL email NEWLINE # enviarEmail
;

calculos: calculos op=('*'|'/') calculos # MulDiv
| calculos op=('+'|'-') calculos # AddSub
| INT # int
;

consulta: INT ' ' ID # Id // id do que se pretende consultar
;

condicao: SE INT '=' INT # CondicaoValidacao
| SE INT '>' INT # CondicaoValidacao
| SE INT '<' INT # CondicaoValidacao
;

email: PARA ENDERECO_EMAIL',' STRING ',' STRING
;

NEWLINE : [\r\n]+ ;
INT : [0-9]+ ;
ID : [a-z]+ ;
MUL : '*' ; // assigns token name to '*' used above in grammar
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
SE : 'Se' ;
ENVIAR : 'Enviar' ;
EMAIL : 'Email' ;
PARA : ' para ' ;
CONSULTA: 'Consulta ';
CALCULOS: 'Calculos ';
ENDERECO_EMAIL : [A-Za-z0-9._%+-]+'@'[A-Za-z0-9.-]+'.'([A-Za-z][A-Za-z] | [A-Za-z][A-Za-z][A-Za-z] | [A-Za-z][A-Za-z][A-Za-z][A-Za-z]);
STRING : [a-zA-Z0-9]+; //pode ser qualquer coisa