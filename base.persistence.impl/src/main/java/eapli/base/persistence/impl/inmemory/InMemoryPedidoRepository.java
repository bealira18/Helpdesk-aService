package eapli.base.persistence.impl.inmemory;

import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.repository.PedidoRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryPedidoRepository extends InMemoryDomainRepository<Pedido, Integer> implements PedidoRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Pedido> pedidosFinalizados(final int numColaborador){throw new UnsupportedOperationException();}

    @Override
    public Pedido procurarPedidoPorIdInfoTarefa(int idInfoTarefa){throw new UnsupportedOperationException();}

}
