package eapli.base.tarefamanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.repository.TarefaRepository;
import java.util.Optional;

public class ReivindicarTarefaController {

    private final TarefaRepository tarefaRepository = PersistenceContext.repositories().tarefa();
    private final ColaboradorRepository colabRepository = PersistenceContext.repositories().colaborador();

    public void reivindicarTarefaPendente(int idTarefa, int numColaborador) {
        Optional<Colaborador> colaborador = colabRepository.ofIdentity(new Numero(numColaborador));
        if (colaborador.isEmpty()) {
            throw new IllegalArgumentException("Não existe nenhum colaborador com o numero: " + numColaborador);
        }
        Colaborador colaborador1 = colaborador.get();
        Iterable<Tarefa> tarefas = tarefaRepository.findAll();
        Tarefa tarefa1 = null;
        for (Tarefa t : tarefas) {
            if (t.obterIdTarefa() == idTarefa) {
                tarefa1 = t;
            }
        }
        if (tarefa1 == null) {
            throw new IllegalArgumentException("Não existe nenhuma tarefa com o ID: " + idTarefa);
        }

        reivindicarTarefa(tarefa1, colaborador1);

    }

    public Colaborador reivindicarTarefa(Tarefa tarefa, Colaborador colaborador) {

        colaborador.reivindicarTarefa(tarefa);
        tarefaRepository.save(tarefa);
        return colabRepository.save(colaborador);
    }

}
