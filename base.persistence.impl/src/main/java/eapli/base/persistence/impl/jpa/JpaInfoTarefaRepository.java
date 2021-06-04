package eapli.base.persistence.impl.jpa;

import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.repository.InfoTarefaRepository;
import eapli.framework.domain.repositories.DomainRepository;

import javax.persistence.TypedQuery;

public class JpaInfoTarefaRepository extends BasepaRepositoryBase<InfoTarefa, Integer, Integer> implements InfoTarefaRepository {

    public JpaInfoTarefaRepository() {
        super("id");
    }

    @Override
    public Iterable<InfoTarefa> filtarInfoTarefaporIdDoColaborador(final int idColaborador) {
        final TypedQuery<InfoTarefa> query = entityManager().createQuery(
                "SELECT d FROM InfoTarefa d JOIN d.colaborador aind WHERE aind.id.numero = :COLABORADOR_NUMERO",
                InfoTarefa.class);
        query.setParameter("COLABORADOR_NUMERO", idColaborador);

        return query.getResultList();
    }
}

