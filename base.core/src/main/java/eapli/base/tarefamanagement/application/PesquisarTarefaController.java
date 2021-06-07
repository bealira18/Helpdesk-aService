package eapli.base.tarefamanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.base.tarefamanagement.repository.InfoTarefaRepository;
import eapli.base.tarefamanagement.repository.TarefaManualRepository;

public class PesquisarTarefaController {

    private final TarefaManualRepository tmRepository = PersistenceContext.repositories().tarefaManual();
    private final InfoTarefaRepository infoTarefaRepository = PersistenceContext.repositories().infoTarefa();

    public TarefaManual procurarTarefaPorID(int id){
        return tmRepository.ofIdentity(id).get();
    }

    public InfoTarefa procurarInfoTarefaPorID(int id){
        return infoTarefaRepository.ofIdentity(id).get();
    }

}
