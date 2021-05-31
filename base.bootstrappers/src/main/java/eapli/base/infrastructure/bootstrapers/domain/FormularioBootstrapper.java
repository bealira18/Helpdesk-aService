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

        addFormularioController.adicionarFormulario("Formulario1");
        addFormularioController.adicionarFormulario("Formulario2");

        associarAtributoAFormularioController.associarAtributoAFormulario("Formulario1","CC");
        associarAtributoAFormularioController.associarAtributoAFormulario("Formulario2","CC");

        atafc.associarTarefaAFormularioIds(1, 1);
        atafc.associarTarefaAFormularioIds(2, 2);
        atafc.associarTarefaAFormularioIds(1, 3);

        afasc.associarFormularioAServicoComNome("Formulario1","cod1");
        afasc.associarFormularioAServicoComNome("Formulario2", "cod2");

        return true;
    }


}
