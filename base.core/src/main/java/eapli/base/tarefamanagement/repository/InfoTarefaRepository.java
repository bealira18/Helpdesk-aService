package eapli.base.tarefamanagement.repository;

import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.framework.domain.repositories.DomainRepository;

public interface InfoTarefaRepository extends DomainRepository<Integer, InfoTarefa> {


    Iterable<InfoTarefa> filtarInfoTarefaporIdDoColaborador(int idColaborador);
}
