package eapli.base.tarefamanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.tarefamanagement.domain.EstadoTarefa;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.base.tarefamanagement.repository.InfoTarefaRepository;
import eapli.base.tarefamanagement.repository.TarefaManualRepository;
import eapli.base.tarefamanagement.repository.TarefaRepository;

import java.util.Optional;

public class ReivindicarTarefaController {

    private final ColaboradorRepository colabRepository = PersistenceContext.repositories().colaborador();
    private final InfoTarefaRepository infotarefaRepository = PersistenceContext.repositories().infoTarefa();

    public InfoTarefa reivindicarTarefaPendente(int idInfoTarefa, int numColaborador) {

        InfoTarefa it=verificarInfoTarefaID(idInfoTarefa);
        Colaborador c=verificarColaboradorNum(numColaborador);

        if(c==null) {
            throw new IllegalArgumentException("Colaborador inválido com número: " + numColaborador);
        }

        if(it==null) {
            throw new IllegalArgumentException("Tarefa inválida com id: " + idInfoTarefa);
        }

        c.reivindicarTarefa(it);
        it.associarColaborador(c);
        it.mudarEstado(EstadoTarefa.ATRIBUIDA);
        colabRepository.save(c);

        return infotarefaRepository.save(it);
    }

    public Colaborador verificarColaboradorNum(int num){
        return colabRepository.ofIdentity(new Numero(num)).get();
    }

    public InfoTarefa verificarInfoTarefaID(int id){
        return infotarefaRepository.ofIdentity(id).get();
    }

}
