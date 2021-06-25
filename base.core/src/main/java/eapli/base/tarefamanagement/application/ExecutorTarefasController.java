package eapli.base.tarefamanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.domain.EstadoTarefa;
import eapli.base.tarefamanagement.domain.ExecutorTarefas;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.repository.ExecutorTarefasRepository;
import eapli.base.tarefamanagement.repository.InfoTarefaRepository;
import eapli.base.tarefamanagement.repository.TarefaRepository;


public class ExecutorTarefasController {

    private final ExecutorTarefasRepository executorTarefasRepository = PersistenceContext.repositories().executorTarefas();
    private final InfoTarefaRepository infoTarefaRepository = PersistenceContext.repositories().infoTarefa();

    public ExecutorTarefas criarExecutorTarefas(String nome) {

        final ExecutorTarefas novoExecutor = new ExecutorTarefas(nome);

        return executorTarefasRepository.save(novoExecutor);

    }

    public ExecutorTarefas associarTarefaAExecutorTarefas(int idInfoTarefa, int idExecutorTarefas){
        InfoTarefa it= infoTarefaRepository.ofIdentity(idInfoTarefa).get();
        ExecutorTarefas et = executorTarefasRepository.ofIdentity(idExecutorTarefas).get();

        if(et==null) {
            throw new IllegalArgumentException("Executor de Tarefas inválido com id: " + idExecutorTarefas);
        }

        if(it==null) {
            throw new IllegalArgumentException("Tarefa inválida com id: " + idInfoTarefa);
        }

        et.reivindicarTarefa(it);
        it.associarExecutor(et);
        it.mudarEstado(EstadoTarefa.ATRIBUIDA);
        infoTarefaRepository.save(it);

        return executorTarefasRepository.save(et);

    }
}