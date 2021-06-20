package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.formulariomanagement.application.AdicionarAtributoController;
import eapli.base.formulariomanagement.application.AssociarAtributoAFormularioController;
import eapli.framework.actions.Action;

public class AtributoBootstrapper implements Action {

    private final AdicionarAtributoController aac =new AdicionarAtributoController();

    @Override
    public boolean execute() {

        //formulario pedido servico 1
        aac.adicionarAtributo("Dias","periodo","Periodo ausencia em dias","[0-9]+","Integer");
        aac.adicionarAtributo("Ausencia","tipo","Tipo Ausencia","[a-zA-Z]+","String");
        aac.adicionarAtributo("Justificacao","justificacao","Justificacao","[a-zA-Z]+","String");

        //formulario tarefa aprovacao servico1
        aac.adicionarAtributo("Decisao","decisao","Decisao","[a-zA-Z]+","String");
        aac.adicionarAtributo("Fundamentacao","fundamentacao","Fundamentacao","[a-zA-Z]+","String");

        //formulario tarefa realizacao servico1
        aac.adicionarAtributo("Dias Gozados","dias","Dias ja gozados no ano","[0-9]+","Integer");
        aac.adicionarAtributo("Dias Gozados Periodo","dias","Dias ja gozados no ano","[0-9]+","Integer");
        aac.adicionarAtributo("Dias Ferias","dias","Dias ja gozados no ano","[0-9]+","Integer");
        aac.adicionarAtributo("Dias Faltas Justificadas","dias","Dias ja gozados no ano","[0-9]+","Integer");
        aac.adicionarAtributo("Dias Faltas Nao Justificadas no Ano","dias","Dias ja gozados no ano","[0-9]+","Integer");
        aac.adicionarAtributo("Dias Faltas Nao Justificadas no Periodo","dias","Dias ja gozados no ano","[0-9]+","Integer");
        aac.adicionarAtributo("Dias Faltas Nao Justificadas Totais","dias","Dias ja gozados no ano","[0-9]+","Integer");
        aac.adicionarAtributo("Comentario","dias","Dias ja gozados no ano","[0-9]+","Integer");

        return true;
    }

}
