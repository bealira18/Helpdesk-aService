package eapli.base.tarefamanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.repository.InfoTarefaRepository;
import eapli.base.tarefamanagement.repository.TarefaRepository;

public class TempoMedioTarefaController {

    private final TarefaRepository tmRepository = PersistenceContext.repositories().tarefa();
    private final InfoTarefaRepository infoTarefaRepository=PersistenceContext.repositories().infoTarefa();

    public Tarefa atualizaTempoMedioA(int id){
        if(procurarTarefaPorID(id).obterTipo()==false){
            throw new IllegalArgumentException("Tarefa de Resolução");
        }

        Iterable<InfoTarefa> tarefas=infoTarefaRepository.tarefasAprovacao();

        int count=0,total=0;

        for(InfoTarefa i : tarefas){
            count++;
            total+=i.obterTempoDecorrido();
        }

        int media=total/count;

        Tarefa t=procurarTarefaPorID(id);

        t.atualizarTempoMedioA(media);

        return tmRepository.save(t);
    }

    public Tarefa atualizaTempoMedioR(int id){
        if(procurarTarefaPorID(id).obterTipo()==true){
            throw new IllegalArgumentException("Tarefa de Aprovação");
        }

        Iterable<InfoTarefa> tarefas=infoTarefaRepository.tarefasRealizacao();

        int count=0,total=0;

        for(InfoTarefa i : tarefas){
            count++;
            total+=i.obterTempoDecorrido();
        }

        int media=total/count;

        Tarefa t=procurarTarefaPorID(id);

        t.atualizarTempoMedioR(media);

        return tmRepository.save(t);
    }

    public Tarefa procurarTarefaPorID(int id){
        return tmRepository.ofIdentity(id).get();
    }
}
