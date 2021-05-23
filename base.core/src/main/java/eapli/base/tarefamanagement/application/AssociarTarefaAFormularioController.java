package eapli.base.tarefamanagement.application;

import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.repository.FormularioRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.base.tarefamanagement.repository.TarefaManualRepository;

public class AssociarTarefaAFormularioController {

    private final FormularioRepository formularioRepository= PersistenceContext.repositories().formulario();
    private final TarefaManualRepository tarefaRepository= PersistenceContext.repositories().tarefaManual();

    public TarefaManual associarTarefaAFormularioIds(int idF,int idT){

        Formulario f=verificarFormularioId(idF);
        TarefaManual t=verificarTarefaId(idT);

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

    public TarefaManual verificarTarefaId(int id){

        Iterable<TarefaManual> tarefas=tarefaRepository.findAll();

        for(TarefaManual t : tarefas){
            if(t.obterId()==id)
                return t;
        }

        return null;
    }

}
