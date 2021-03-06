package eapli.base.tarefamanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.base.tarefamanagement.repository.TarefaManualRepository;

import java.util.Date;

public class CriarTarefaManualController {

    private final TarefaManualRepository tarefaManualRepository = PersistenceContext.repositories().tarefaManual();

    public TarefaManual criarTarefaManual(String descricao,boolean aprovacao) {

        final TarefaManual novaTarefaManual = new TarefaManual(descricao, aprovacao);

        return tarefaManualRepository.save(novaTarefaManual);

    }

    public TarefaManual criarTarefaManualWorkflow(String descricao,boolean aprovacao) {

        final TarefaManual novaTarefaManual = new TarefaManual(descricao, aprovacao);

        return tarefaManualRepository.save(novaTarefaManual);

    }

    public TarefaManual procurarTarefaID(int id){
        return tarefaManualRepository.ofIdentity(id).get();
    }

}
