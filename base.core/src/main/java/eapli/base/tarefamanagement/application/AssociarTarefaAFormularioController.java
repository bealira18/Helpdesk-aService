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
    private final TarefaManualRepository tarefaManualRepository= PersistenceContext.repositories().tarefaManual();
    private final TarefaRepository tarefaRepository= PersistenceContext.repositories().tarefa();

    public TarefaManual associarTarefaAFormularioIds(int idF,int idT){

        Formulario f=verificarFormularioId(idF);
        TarefaManual t= (TarefaManual) verificarTarefaId(idT);

        if(f==null)
            throw new IllegalArgumentException("Formulario inválido com id: "+idF);

        if(t==null)
            throw new IllegalArgumentException("Tarefa inválida com id: "+idT);

        t.addFormulario(f);

        return tarefaRepository.save(t);
    }

    public Formulario verificarFormularioId(int id){

        Iterable<Formulario> formularios=formularioRepository.findAll();

        for(Formulario f : formularios){
            if(f.obterId()==id)
                return f;
        }

        return null;
    }

    public Tarefa verificarTarefaId(int id){

        Iterable<Tarefa> tarefas=tarefaRepository.findAll();

        for(Tarefa t : tarefas){
            if(t.obterId()==id)
                return t;
        }

        return null;
    }

}
