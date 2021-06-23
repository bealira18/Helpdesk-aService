package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.formulariomanagement.application.AdicionarAtributoController;
import eapli.base.formulariomanagement.application.AdicionarFormularioController;
import eapli.base.formulariomanagement.application.AssociarAtributoAFormularioController;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.repository.AtributoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.formulariomanagement.repository.FormularioRepository;
import eapli.base.servicomanagement.application.AssociarFormularioAServicoController;
import eapli.base.tarefamanagement.application.AssociarTarefaAFormularioController;
import eapli.framework.actions.Action;

public class FormularioBootstrapper implements Action{
    
    private final AdicionarFormularioController addFormularioController=new AdicionarFormularioController();
    private final AssociarAtributoAFormularioController associarAtributoAFormularioController=new AssociarAtributoAFormularioController();
    private final AssociarTarefaAFormularioController atafc = new AssociarTarefaAFormularioController();
    private final AssociarFormularioAServicoController afasc = new AssociarFormularioAServicoController();
    @Override
    public boolean execute() {

        addFormularioController.adicionarFormulario("Formulario_Pedido");
        addFormularioController.adicionarFormulario("Formulario_Aprovacao");
        addFormularioController.adicionarFormulario("Formulario_Realizacao");

        associarAtributoAFormularioController.associarAtributoAFormulario("Formulario_Pedido","Dias");
        associarAtributoAFormularioController.associarAtributoAFormulario("Formulario_Pedido","Ausencia");
        associarAtributoAFormularioController.associarAtributoAFormulario("Formulario_Pedido","Justificacao");

        associarAtributoAFormularioController.associarAtributoAFormulario("Formulario_Aprovacao","Decisao");
        associarAtributoAFormularioController.associarAtributoAFormulario("Formulario_Aprovacao","Fundamentacao");

        associarAtributoAFormularioController.associarAtributoAFormulario("Formulario_Realizacao","Dias Gozados");
        associarAtributoAFormularioController.associarAtributoAFormulario("Formulario_Realizacao","Dias Gozados Periodo");
        associarAtributoAFormularioController.associarAtributoAFormulario("Formulario_Realizacao","Dias Faltas Justificadas");
        associarAtributoAFormularioController.associarAtributoAFormulario("Formulario_Realizacao","Dias Faltas Nao Justificadas no Ano");
        associarAtributoAFormularioController.associarAtributoAFormulario("Formulario_Realizacao","Dias Faltas Nao Justificadas no Periodo");
        associarAtributoAFormularioController.associarAtributoAFormulario("Formulario_Realizacao","Dias Faltas Nao Justificadas Totais");
        associarAtributoAFormularioController.associarAtributoAFormulario("Formulario_Realizacao","Comentario");

        //formulario 1 pedido - tarefa 1
        atafc.associarTarefaAFormularioIds(2, 1);
        atafc.associarTarefaAFormularioIds(3, 3);

        afasc.associarFormularioAServicoComNome("Formulario_Pedido","cod1");


        addFormularioController.adicionarFormulario("Formulario_Pedido_Morada");
        addFormularioController.adicionarFormulario("Formulario_Realizacao_Morada");

        atafc.associarTarefaAFormularioIds(4, 5);
        afasc.associarFormularioAServicoComNome("Formulario_Pedido_Morada","cod3");

        associarAtributoAFormularioController.associarAtributoAFormulario("Formulario_Pedido_Morada","Morada");
        associarAtributoAFormularioController.associarAtributoAFormulario("Formulario_Realizacao_Morada","Valida_morada");



        return true;
    }


}
