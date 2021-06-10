package eapli.base.persistence.impl.jpa;

import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.repository.InfoTarefaRepository;

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

    @Override
    public Iterable<InfoTarefa> tarefasAprovacao(){
        final TypedQuery<InfoTarefa> query=entityManager().createQuery(
                "SELECT i FROM InfoTarefa i WHERE i.tarefa.aprovacao=true",
                InfoTarefa.class);

        return query.getResultList();
    }

    @Override
    public Iterable<InfoTarefa> tarefasRealizacao(){
        final TypedQuery<InfoTarefa> query=entityManager().createQuery(
                "SELECT i FROM InfoTarefa i WHERE i.tarefa.aprovacao=false",
                InfoTarefa.class);

        return query.getResultList();
    }
}

