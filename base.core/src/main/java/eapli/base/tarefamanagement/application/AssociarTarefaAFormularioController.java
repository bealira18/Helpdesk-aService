package eapli.base.tarefamanagement.application;

import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.repository.FormularioRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.base.tarefamanagement.repository.TarefaManualRepository;
import eapli.base.tarefamanagement.repository.TarefaRepository;

public class AssociarTarefaAFormularioController {

    private final FormularioRepository formularioRepository= PersistenceContext.repositories().formulario();
    private final TarefaRepository tarefaRepository= PersistenceContext.repositories().tarefa();

    public TarefaManual associarTarefaAFormularioIds(int idF,int idT){

        Formulario f=verificarFormularioID(idF);
        TarefaManual t= (TarefaManual) verificarTarefaID(idT);

        if(f==null)
            throw new IllegalArgumentException("Formulario inválido com id: "+idF);

        if(t==null)
            throw new IllegalArgumentException("Tarefa inválida com id: "+idT);

        t.addFormulario(f);

        return tarefaRepository.save(t);
    }

    public Formulario verificarFormularioID(int id){
        return formularioRepository.ofIdentity(id).get();
    }

    public Tarefa verificarTarefaID(int id){
        return tarefaRepository.ofIdentity(id).get();
    }

}
