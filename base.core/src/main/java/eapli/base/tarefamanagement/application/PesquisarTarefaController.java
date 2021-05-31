package eapli.base.tarefamanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.base.tarefamanagement.repository.InfoTarefaRepository;
import eapli.base.tarefamanagement.repository.TarefaManualRepository;

public class PesquisarTarefaController {

    private final TarefaManualRepository tmRepository = PersistenceContext.repositories().tarefaManual();
    private final InfoTarefaRepository infoTarefaRepository = PersistenceContext.repositories().infoTarefa();

    public TarefaManual procurarTarefaPorID(int id) {

        Iterable<TarefaManual> tarefas = tmRepository.findAll();

        TarefaManual tarefaManual = null;

        for (TarefaManual tfM : tarefas) {
            if (tfM.obterId() == id) {
                tarefaManual = tfM;
            }
        }
        return tarefaManual;
    }

    public InfoTarefa procurarInfoTarefaPorID(int id) {

        Iterable<InfoTarefa> tarefas = infoTarefaRepository.findAll();

        InfoTarefa infoTarefa=null;

        for(InfoTarefa it : tarefas) {
            if (it.obterId() == id) {
                infoTarefa = it;
            }
        }
        return infoTarefa;
    }

}
