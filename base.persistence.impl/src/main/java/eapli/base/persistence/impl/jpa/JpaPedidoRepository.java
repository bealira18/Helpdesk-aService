package eapli.base.persistence.impl.jpa;

import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.repository.PedidoRepository;
import eapli.framework.domain.repositories.DomainRepository;

import javax.persistence.TypedQuery;

public class JpaPedidoRepository extends BasepaRepositoryBase<Pedido, Integer, Integer> implements DomainRepository<Integer, Pedido>, PedidoRepository {

    public JpaPedidoRepository(){ super("id");}

    @Override
    public Iterable<Pedido> pedidosFinalizados(int numColaborador) {
        final TypedQuery<Pedido> query = entityManager().createQuery(
                "SELECT p FROM Pedido p WHERE p.dataFim IS NOT null AND p.numeroS = :NUMEROS AND p.feedback = -1",
                Pedido.class);
        query.setParameter("NUMEROS", numColaborador);

        return query.getResultList();
    }

}
