package eapli.base.tarefamanagement.application;

import eapli.base.colaboradormanagement.application.ColaboradorComUserController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.domain.EstadoTarefa;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.repository.InfoTarefaRepository;

import java.util.Calendar;
import java.util.List;

public class ExecutarTarefaManualController {

    private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaborador();
    private final InfoTarefaRepository infoTarefaRepository = PersistenceContext.repositories().infoTarefa();

    public void executarTarefaManual(int numeroColaborador, int idInfoTarefa){
        Colaborador colaborador = colaboradorRepository.ofIdentity(new Numero(numeroColaborador)).get();
        List<InfoTarefa> tarefas = colaborador.tarefas();
        for(InfoTarefa it : tarefas){
            if(it.obterId()==idInfoTarefa){
                it.mudarEstado(EstadoTarefa.TERMINADA);
                it.mudarDataFim(Calendar.getInstance().getTime());
                int tempoDecorrido = (int)((it.obterDataFim().getTime() - it.obterDataInicio().getTime())/60000);
                it.mudarTempoDecorrido(tempoDecorrido);
                infoTarefaRepository.save(it);
            }
        }
    }

    public List<InfoTarefa> listarTarefasPendentesDoColaborador(int numeroColaborador){
        Colaborador colaborador = colaboradorRepository.ofIdentity(new Numero(numeroColaborador)).get();
        return colaborador.tarefas();
    }
}
