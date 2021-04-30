package eapli.base.persistence.impl.inmemory;

import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.repository.PedidoRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryPedidoRepository extends InMemoryDomainRepository<Pedido, Integer> implements PedidoRepository {

    static {
        InMemoryInitializer.init();
    }
}
