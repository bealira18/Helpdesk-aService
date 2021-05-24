package eapli.base.tarefamanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.base.tarefamanagement.repository.TarefaManualRepository;
import java.util.Optional;

public class ReivindicarTarefaController {

    private final TarefaManualRepository tarefaManualRepository = PersistenceContext.repositories().tarefaManual();
    private final ColaboradorRepository colabRepository = PersistenceContext.repositories().colaborador();

    public TarefaManual reivindicarTarefaPendente(int idTarefaManual, int numColaborador) {

        TarefaManual tm = verificarTarefa(idTarefaManual);

        Colaborador c = verificarColaborador(numColaborador);

        if(c==null) {
            throw new IllegalArgumentException("Colaborador inválido com número: " + numColaborador);
        }

        if(tm==null) {
            throw new IllegalArgumentException("Tarefa Manual inválida com id: " + idTarefaManual);
        }

        c.reivindicarTarefa(tm);

        tm.associarColaborador(c);

        colabRepository.save(c);

        return tarefaManualRepository.save(tm);
    }

    /*public Colaborador reivindicarTarefa(TarefaManual tarefa, Colaborador colaborador) {

        colaborador.reivindicarTarefa(tarefa);
        tarefa.associarColaborador(colaborador);
        tarefaManualRepository.save(tarefa);
        return colabRepository.save(colaborador);
    }*/

    public Colaborador verificarColaborador(int numero){
        Iterable<Colaborador> colaboradores = colabRepository.findAll();
        Colaborador colab = null;
        for (Colaborador c : colaboradores) {
            if (c.obterNumero().obterNumero() == numero) {
                colab = c;
            }
        }
        return colab;
    }

    public TarefaManual verificarTarefa(int idTarefaManual){
        Iterable<TarefaManual> tarefas = tarefaManualRepository.findAll();
        TarefaManual tarefa1 = null;
        for (TarefaManual tM : tarefas) {
            if (tM.obterId() == idTarefaManual) {
                tarefa1 = tM;
            }
        }
        return tarefa1;
    }
}
