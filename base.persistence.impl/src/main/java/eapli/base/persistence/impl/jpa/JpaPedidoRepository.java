package eapli.base.persistence.impl.jpa;

import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.repository.PedidoRepository;
import eapli.framework.domain.repositories.DomainRepository;

public class JpaPedidoRepository extends BasepaRepositoryBase<Pedido, Integer, Integer> implements DomainRepository<Integer, Pedido>, PedidoRepository {

    public JpaPedidoRepository(){ super("id");}

}
