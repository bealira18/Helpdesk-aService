package eapli.base.persistence.impl.jpa;

import eapli.base.domain.Pedido;
import eapli.base.repositories.PedidoRepository;
import eapli.framework.domain.repositories.DomainRepository;

public class JpaPedidoRepository extends BasepaRepositoryBase<Pedido, Integer, Integer> implements DomainRepository<Integer, Pedido>, PedidoRepository {

    public JpaPedidoRepository(){ super("id");}

}
