package eapli.base.persistence.impl.jpa;

import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.repository.PedidoRepository;
import eapli.framework.domain.repositories.DomainRepository;

import javax.persistence.TypedQuery;

public class JpaPedidoRepository extends BasepaRepositoryBase<Pedido, Integer, Integer> implements DomainRepository<Integer, Pedido>, PedidoRepository {

    public JpaPedidoRepository() {
        super("id");
    }

    @Override
    public Iterable<Pedido> pedidosFinalizados(int numColaborador) {
        final TypedQuery<Pedido> query = entityManager().createQuery(
                "SELECT p FROM Pedido p WHERE p.dataFim IS NOT null AND p.numeroS = :NUMEROS AND p.feedback = -1 AND (EXTRACT(DAY FROM CURRENT_DATE-p.dataFim) < 7)",
                Pedido.class);
        query.setParameter("NUMEROS", numColaborador);

        return query.getResultList();
    }

    @Override
    public Pedido procurarPedidoPorIdInfoTarefa(int idInfoTarefa) {
        final TypedQuery<Pedido> query = entityManager().createQuery(
                "SELECT p FROM Pedido p, InfoTarefa it WHERE it.id=:IDINFOTAREFA AND it IN(SELECT tar FROM p.tarefas tar)",
                Pedido.class);
        query.setParameter("IDINFOTAREFA", idInfoTarefa);

        return query.getSingleResult();
    }

}
