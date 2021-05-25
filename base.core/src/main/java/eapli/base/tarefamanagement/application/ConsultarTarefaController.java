package eapli.base.tarefamanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.base.tarefamanagement.repository.TarefaManualRepository;
import java.util.ArrayList;
import java.util.List;

public class ConsultarTarefaController {

    private final TarefaManualRepository tarefaManualRepository = PersistenceContext.repositories().tarefaManual();
    private final ColaboradorRepository colabRepository = PersistenceContext.repositories().colaborador();

    public Iterable<TarefaManual> listarTarefasPendentes() {

        Iterable<TarefaManual> tarefas = tarefaManualRepository.findAll();
        List<TarefaManual> tarefasPendentes = new ArrayList<>();

        for (TarefaManual t : tarefas) {
            if (t.obterColaborador() == null) {
                tarefasPendentes.add(t);
            }
        }

        if (tarefasPendentes == null) {
            throw new IllegalArgumentException("Não existem tarefas pendentes.");
        }

        return tarefasPendentes;
    }

    public List<TarefaManual> listarMinhasTarefas(int id) {

        Iterable<TarefaManual> tarefas = tarefaManualRepository.findAll();
        Iterable<Colaborador> colabs = colabRepository.findAll();
        List<TarefaManual> tarefasPendentes = new ArrayList<>();


            for (Colaborador c : colabs){
            if (c.obterNumero().obterNumero() == id) {
                tarefasPendentes = c.tarefas();
            }
        }

        if (tarefasPendentes == null) {
            throw new IllegalArgumentException("Não existem tarefas pendentes para o colaborador indicado.");
        }

        return tarefasPendentes;
    }

}
