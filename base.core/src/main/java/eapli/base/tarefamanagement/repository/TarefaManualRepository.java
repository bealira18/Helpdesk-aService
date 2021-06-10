package eapli.base.tarefamanagement.repository;

import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.framework.domain.repositories.DomainRepository;

public interface TarefaManualRepository extends DomainRepository<Integer, TarefaManual> {

    Iterable<InfoTarefa> procurarTarefasManuaisNaoAtribuidas();

}
