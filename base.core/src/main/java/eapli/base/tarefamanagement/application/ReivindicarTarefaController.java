package eapli.base.tarefamanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.base.tarefamanagement.repository.TarefaManualRepository;
import java.util.Optional;

public class ReivindicarTarefaController {

    private final TarefaManualRepository tarefaManualRepository = PersistenceContext.repositories().tarefaManual();
    private final ColaboradorRepository colabRepository = PersistenceContext.repositories().colaborador();

    public void reivindicarTarefaPendente(int idTarefaManual, int numColaborador) {
        Optional<Colaborador> colaborador = colabRepository.ofIdentity(new Numero(numColaborador));
        if (colaborador.isEmpty()) {
            throw new IllegalArgumentException("Não existe nenhum colaborador com o numero: " + numColaborador);
        }
        Colaborador colaborador1 = colaborador.get();
        Iterable<TarefaManual> tarefas = tarefaManualRepository.findAll();
        TarefaManual tarefa1 = null;
        for (TarefaManual tM : tarefas) {
            if (tM.obterIdTarefa() == idTarefaManual) {
                tarefa1 = tM;
            }
        }
        if (tarefa1 == null) {
            throw new IllegalArgumentException("Não existe nenhuma tarefa manual com o ID: " + idTarefaManual);
        }

        reivindicarTarefa(tarefa1, colaborador1);

    }

    public Colaborador reivindicarTarefa(TarefaManual tarefa, Colaborador colaborador) {

        colaborador.reivindicarTarefa(tarefa);
        tarefa.associarColaborador(colaborador);
        tarefaManualRepository.save(tarefa);
        return colabRepository.save(colaborador);
    }

}
