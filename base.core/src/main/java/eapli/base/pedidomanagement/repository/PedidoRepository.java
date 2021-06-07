package eapli.base.pedidomanagement.repository;

import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.framework.domain.repositories.DomainRepository;

public interface PedidoRepository extends DomainRepository<Integer, Pedido> {

    Iterable<Pedido> pedidosFinalizados(int numColaborador);

}
