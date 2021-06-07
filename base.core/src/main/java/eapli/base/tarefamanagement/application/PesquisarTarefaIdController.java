package eapli.base.tarefamanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repository.ServicoRepository;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.repository.TarefaRepository;

public class PesquisarTarefaIdController {

    private final TarefaRepository tarefaRepository = PersistenceContext.repositories().tarefa();

    public Tarefa procurarTarefaPorId(int id){
        return tarefaRepository.ofIdentity(id).get();
    }
}
