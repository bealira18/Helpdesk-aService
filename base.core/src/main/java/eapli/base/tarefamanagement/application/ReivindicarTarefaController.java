package eapli.base.tarefamanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.base.tarefamanagement.repository.InfoTarefaRepository;
import eapli.base.tarefamanagement.repository.TarefaManualRepository;
import eapli.base.tarefamanagement.repository.TarefaRepository;

import java.util.Optional;

public class ReivindicarTarefaController {

    private final TarefaManualRepository tarefaManualRepository = PersistenceContext.repositories().tarefaManual();
    private final ColaboradorRepository colabRepository = PersistenceContext.repositories().colaborador();
    private final InfoTarefaRepository infotarefaRepository = PersistenceContext.repositories().infoTarefa();

    public InfoTarefa reivindicarTarefaPendente(int idInfoTarefa, int numColaborador) {

        InfoTarefa it=verificarTarefa(idInfoTarefa);
        Colaborador c=verificarColaborador(numColaborador);

        if(c==null) {
            throw new IllegalArgumentException("Colaborador inválido com número: " + numColaborador);
        }

        if(it==null) {
            throw new IllegalArgumentException("Tarefa inválida com id: " + idInfoTarefa);
        }

        c.reivindicarTarefa(it);
        it.associarColaborador(c);
        colabRepository.save(c);

        return infotarefaRepository.save(it);
    }

    /*public Colaborador reivindicarTarefa(TarefaManual tarefa, Colaborador colaborador) {

        colaborador.reivindicarTarefa(tarefa);
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

    public InfoTarefa verificarTarefa(int idTarefa){
        Iterable<InfoTarefa> tarefas=infotarefaRepository.findAll();

        InfoTarefa tarefa=null;

        for (InfoTarefa it : tarefas) {
            if (it.obterId()==idTarefa) {
                tarefa=it;
            }
        }

        return tarefa;
    }
}
